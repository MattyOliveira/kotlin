package foo

// NOTE THIS FILE IS AUTO-GENERATED by the generateTestDataForReservedWords.kt. DO NOT EDIT!

class TestClass {
    var `false`: Int = 0

    fun test() {
        testNotRenamed("false", { `false` })
    }
}

fun box(): String {
    TestClass().test()

    return "OK"
}