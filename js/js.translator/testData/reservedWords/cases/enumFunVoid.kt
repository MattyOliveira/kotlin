package foo

// NOTE THIS FILE IS AUTO-GENERATED by the generateTestDataForReservedWords.kt. DO NOT EDIT!

enum class Foo {
    BAR
    fun void() { void() }

    fun test() {
        testNotRenamed("void", { ::void })
    }
}

fun box(): String {
    Foo.BAR.test()

    return "OK"
}