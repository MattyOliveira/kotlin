package foo

// NOTE THIS FILE IS AUTO-GENERATED by the generateTestDataForReservedWords.kt. DO NOT EDIT!

object TestObject {
    fun foo(protected: String) {
    assertEquals("123", protected)
    testRenamed("protected", { protected })
}

    fun test() {
        foo("123")
    }
}

fun box(): String {
    TestObject.test()

    return "OK"
}