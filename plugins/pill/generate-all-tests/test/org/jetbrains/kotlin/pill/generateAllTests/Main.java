/*
 * Copyright 2000-2018 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.pill.generateAllTests;

import org.jetbrains.kotlin.generators.tests.*;

public class Main {
    public static void main(String[] args) {
        GenerateCompilerTestsKt.main();
        GenerateTestsKt.main();
        GenerateJsTestsKt.main();
        GenerateJava8TestsKt.main();
        GenerateRuntimeDescriptorTestsKt.main();
    }
}
