/*
 * Copyright 2010-2019 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.cli

import junit.framework.TestCase
import org.jetbrains.kotlin.cli.common.CompilerSystemProperties
import org.jetbrains.kotlin.test.TestCaseWithTmpdir
import org.jetbrains.kotlin.utils.PathUtil
import org.junit.Assert
import java.io.*
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread

class LauncherReplTest : TestCaseWithTmpdir() {

    private fun runInteractive(
        vararg inputsToExpectedOutputs: Pair<String?, String>,
        expectedExitCode: Int = 0,
        workDirectory: File? = null
    ) {
        val javaExecutable = File(File(CompilerSystemProperties.JAVA_HOME.safeValue, "bin"), "java")

        val processBuilder = ProcessBuilder(
            javaExecutable.absolutePath,
            "-jar",
            File(PathUtil.kotlinPathsForDistDirectory.homePath, "lib/kotlin-compiler.jar").absolutePath,
        )
        if (workDirectory != null) {
            processBuilder.directory(workDirectory)
        }
        val process = processBuilder.start()

        data class ExceptionContainer(
            var value: Throwable? = null
        )

        fun InputStream.captureStream(): Triple<Thread, ExceptionContainer, ArrayList<String>> {
            val out = ArrayList<String>()
            val exceptionContainer = ExceptionContainer()
            val thread = thread {
                val promptRegex = Regex("(?:\\u001B\\p{Graph}+)*(?:>>>|\\.\\.\\.)")
                try {
                    reader().forEachLine { rawLine ->
                        promptRegex.split(rawLine).forEach { line ->
                            if (line.isNotEmpty()) {
                                out.add(line.trim())
                            }
                        }
                    }
                } catch (e: Throwable) {
                    exceptionContainer.value = e
                }
            }
            return Triple(thread, exceptionContainer, out)
        }

        val (stdoutThread, stdoutException, processOut) = process.inputStream.captureStream()
        val (stderrThread, stderrException, processErr) = process.errorStream.captureStream()

        val inputIter = inputsToExpectedOutputs.iterator()
        var stdinException: Throwable? = null
        val stdinThread =
            thread {
                try {
                    writeInputsToOutStream(process.outputStream, inputIter)
                } catch (e: Throwable) {
                    stdinException = e
                }
            }

        process.waitFor(10000, TimeUnit.MILLISECONDS)

        try {
            if (process.isAlive) {
                process.destroyForcibly()
                TestCase.fail("Process terminated forcibly")
            }
            stdoutThread.join(100)
            TestCase.assertFalse("stdout thread not finished", stdoutThread.isAlive)
            TestCase.assertNull(stdoutException.value)
            stderrThread.join(100)
            TestCase.assertFalse("stderr thread not finished", stderrThread.isAlive)
            TestCase.assertNull(stderrException.value)
            TestCase.assertFalse("stdin thread not finished", stdinThread.isAlive)
            TestCase.assertNull(stdinException)
            assertOutputMatches(inputsToExpectedOutputs, processOut)
            TestCase.assertEquals(expectedExitCode, process.exitValue())
            TestCase.assertFalse(inputIter.hasNext())

        } catch (e: Throwable) {
            println("OUT:\n${processOut.joinToString("\n")}")
            println("ERR:\n${processErr.joinToString("\n")}")
            println("REMAINING IN:\n${inputIter.asSequence().joinToString("\n")}")
            throw e
        }
    }

    private fun writeInputsToOutStream(dataOutStream: OutputStream, inputIter: Iterator<Pair<String?, String>>) {
        val writer = dataOutStream.writer()
        val eol = System.getProperty("line.separator")

        fun writeNextInput(nextInput: String) {
            with(writer) {
                write(nextInput)
                write(eol)
                flush()
            }
        }

        while (inputIter.hasNext()) {
            val nextInput = inputIter.next().first ?: continue
            writeNextInput(nextInput)
        }
        writeNextInput(":quit")
    }

    private fun assertOutputMatches(
        inputsToExpectedOutputs: Array<out Pair<String?, String>>,
        actualOut: List<String>
    ) {
        val inputsToExpectedOutputsIter = inputsToExpectedOutputs.iterator()
        val actualIter = actualOut.iterator()

        while (true) {
            if (inputsToExpectedOutputsIter.hasNext() && !actualIter.hasNext()) {
                Assert.fail("missing output for expected patterns:\n${inputsToExpectedOutputsIter.asSequence().joinToString("\n") { it.second } }")
            }
            if (!inputsToExpectedOutputsIter.hasNext() || !actualIter.hasNext()) break
            val (input, expectedPattern) = inputsToExpectedOutputsIter.next()
            val actualLine = actualIter.next()
            val strippedActualLine = if (input != null) actualLine.removePrefix(input) else actualLine
            assertTrue(
                "line \"$strippedActualLine\" do not match with expected pattern \"$expectedPattern\"",
                Regex(expectedPattern).matches(strippedActualLine)
            )
        }
    }

    val replOutHeader = arrayOf(
        null to "Welcome to Kotlin version .*",
        null to "Type :help for help, :quit for quit"
    )

    fun testSimpleRepl() {
        runInteractive(
            *replOutHeader,
            "println(42)" to "42",
        )
    }

    fun testReplResultFormatting() {
        runInteractive(
            *replOutHeader,
            "class C" to "",
            "C()" to "res1: Line_0\\.C = Line_0\\\$C@\\p{XDigit}+",
        )
    }

    fun testReplValueClassConversion() {
        runInteractive(
            *replOutHeader,
            "import kotlin.time.Duration.Companion.nanoseconds" to "",
            "Result.success(\"OK\")" to "res1: kotlin\\.Result<kotlin\\.String> = Success\\(OK\\)",
            "0U-1U" to "res2: kotlin.UInt = 4294967295",
            "10.nanoseconds" to "res3: kotlin.time.Duration = 10ns",
            "@JvmInline value class Z(val x: Int)" to "",
            "Z(42)" to "res5: Line_4\\.Z = Z\\(x=42\\)",
        )
    }
}
