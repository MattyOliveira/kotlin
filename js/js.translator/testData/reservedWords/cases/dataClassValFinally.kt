package foo

// NOTE THIS FILE IS AUTO-GENERATED by the generateTestDataForReservedWords.kt. DO NOT EDIT!

data class DataClass(val `finally`: String) {
    {
        testNotRenamed("finally", { `finally` })
    }
}

fun box(): String {
    DataClass("123")

    return "OK"
}