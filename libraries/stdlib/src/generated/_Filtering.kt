package kotlin

//
// NOTE THIS FILE IS AUTO-GENERATED by the GenerateStandardLib.kt
// See: https://github.com/JetBrains/kotlin/tree/master/libraries/stdlib
//

import java.util.*

/**
 * Returns a list containing all elements except first *n* elements
 */
public fun <T> Array<out T>.drop(n: Int): List<T> {
    if (n >= size)
        return ArrayList<T>()
    var count = 0
    val list = ArrayList<T>(size - n)
    for (item in this) {
        if (count++ >= n) list.add(item)
    }
    return list
}

/**
 * Returns a list containing all elements except first *n* elements
 */
public fun BooleanArray.drop(n: Int): List<Boolean> {
    if (n >= size)
        return ArrayList<Boolean>()
    var count = 0
    val list = ArrayList<Boolean>(size - n)
    for (item in this) {
        if (count++ >= n) list.add(item)
    }
    return list
}

/**
 * Returns a list containing all elements except first *n* elements
 */
public fun ByteArray.drop(n: Int): List<Byte> {
    if (n >= size)
        return ArrayList<Byte>()
    var count = 0
    val list = ArrayList<Byte>(size - n)
    for (item in this) {
        if (count++ >= n) list.add(item)
    }
    return list
}

/**
 * Returns a list containing all elements except first *n* elements
 */
public fun CharArray.drop(n: Int): List<Char> {
    if (n >= size)
        return ArrayList<Char>()
    var count = 0
    val list = ArrayList<Char>(size - n)
    for (item in this) {
        if (count++ >= n) list.add(item)
    }
    return list
}

/**
 * Returns a list containing all elements except first *n* elements
 */
public fun DoubleArray.drop(n: Int): List<Double> {
    if (n >= size)
        return ArrayList<Double>()
    var count = 0
    val list = ArrayList<Double>(size - n)
    for (item in this) {
        if (count++ >= n) list.add(item)
    }
    return list
}

/**
 * Returns a list containing all elements except first *n* elements
 */
public fun FloatArray.drop(n: Int): List<Float> {
    if (n >= size)
        return ArrayList<Float>()
    var count = 0
    val list = ArrayList<Float>(size - n)
    for (item in this) {
        if (count++ >= n) list.add(item)
    }
    return list
}

/**
 * Returns a list containing all elements except first *n* elements
 */
public fun IntArray.drop(n: Int): List<Int> {
    if (n >= size)
        return ArrayList<Int>()
    var count = 0
    val list = ArrayList<Int>(size - n)
    for (item in this) {
        if (count++ >= n) list.add(item)
    }
    return list
}

/**
 * Returns a list containing all elements except first *n* elements
 */
public fun LongArray.drop(n: Int): List<Long> {
    if (n >= size)
        return ArrayList<Long>()
    var count = 0
    val list = ArrayList<Long>(size - n)
    for (item in this) {
        if (count++ >= n) list.add(item)
    }
    return list
}

/**
 * Returns a list containing all elements except first *n* elements
 */
public fun ShortArray.drop(n: Int): List<Short> {
    if (n >= size)
        return ArrayList<Short>()
    var count = 0
    val list = ArrayList<Short>(size - n)
    for (item in this) {
        if (count++ >= n) list.add(item)
    }
    return list
}

/**
 * Returns a list containing all elements except first *n* elements
 */
public fun <T> Collection<T>.drop(n: Int): List<T> {
    if (n >= size)
        return ArrayList<T>()
    var count = 0
    val list = ArrayList<T>(size - n)
    for (item in this) {
        if (count++ >= n) list.add(item)
    }
    return list
}

/**
 * Returns a list containing all elements except first *n* elements
 */
public fun <T> Iterable<T>.drop(n: Int): List<T> {
    var count = 0
    val list = ArrayList<T>()
    for (item in this) {
        if (count++ >= n) list.add(item)
    }
    return list
}

/**
 * Returns a stream containing all elements except first *n* elements
 */
public fun <T> Stream<T>.drop(n: Int): Stream<T> {
    return DropStream(this, n)
}

/**
 * Returns a list containing all elements except first *n* elements
 */
public fun String.drop(n: Int): String {
    return substring(Math.min(n, size))
}

/**
 * Returns a list containing all elements except first elements that satisfy the given *predicate*
 */
public inline fun <T> Array<out T>.dropWhile(predicate: (T) -> Boolean): List<T> {
    var yielding = false
    val list = ArrayList<T>()
    for (item in this)
        if (yielding)
            list.add(item)
        else if (!predicate(item)) {
            list.add(item)
            yielding = true
        }
    return list
}

/**
 * Returns a list containing all elements except first elements that satisfy the given *predicate*
 */
public inline fun BooleanArray.dropWhile(predicate: (Boolean) -> Boolean): List<Boolean> {
    var yielding = false
    val list = ArrayList<Boolean>()
    for (item in this)
        if (yielding)
            list.add(item)
        else if (!predicate(item)) {
            list.add(item)
            yielding = true
        }
    return list
}

/**
 * Returns a list containing all elements except first elements that satisfy the given *predicate*
 */
public inline fun ByteArray.dropWhile(predicate: (Byte) -> Boolean): List<Byte> {
    var yielding = false
    val list = ArrayList<Byte>()
    for (item in this)
        if (yielding)
            list.add(item)
        else if (!predicate(item)) {
            list.add(item)
            yielding = true
        }
    return list
}

/**
 * Returns a list containing all elements except first elements that satisfy the given *predicate*
 */
public inline fun CharArray.dropWhile(predicate: (Char) -> Boolean): List<Char> {
    var yielding = false
    val list = ArrayList<Char>()
    for (item in this)
        if (yielding)
            list.add(item)
        else if (!predicate(item)) {
            list.add(item)
            yielding = true
        }
    return list
}

/**
 * Returns a list containing all elements except first elements that satisfy the given *predicate*
 */
public inline fun DoubleArray.dropWhile(predicate: (Double) -> Boolean): List<Double> {
    var yielding = false
    val list = ArrayList<Double>()
    for (item in this)
        if (yielding)
            list.add(item)
        else if (!predicate(item)) {
            list.add(item)
            yielding = true
        }
    return list
}

/**
 * Returns a list containing all elements except first elements that satisfy the given *predicate*
 */
public inline fun FloatArray.dropWhile(predicate: (Float) -> Boolean): List<Float> {
    var yielding = false
    val list = ArrayList<Float>()
    for (item in this)
        if (yielding)
            list.add(item)
        else if (!predicate(item)) {
            list.add(item)
            yielding = true
        }
    return list
}

/**
 * Returns a list containing all elements except first elements that satisfy the given *predicate*
 */
public inline fun IntArray.dropWhile(predicate: (Int) -> Boolean): List<Int> {
    var yielding = false
    val list = ArrayList<Int>()
    for (item in this)
        if (yielding)
            list.add(item)
        else if (!predicate(item)) {
            list.add(item)
            yielding = true
        }
    return list
}

/**
 * Returns a list containing all elements except first elements that satisfy the given *predicate*
 */
public inline fun LongArray.dropWhile(predicate: (Long) -> Boolean): List<Long> {
    var yielding = false
    val list = ArrayList<Long>()
    for (item in this)
        if (yielding)
            list.add(item)
        else if (!predicate(item)) {
            list.add(item)
            yielding = true
        }
    return list
}

/**
 * Returns a list containing all elements except first elements that satisfy the given *predicate*
 */
public inline fun ShortArray.dropWhile(predicate: (Short) -> Boolean): List<Short> {
    var yielding = false
    val list = ArrayList<Short>()
    for (item in this)
        if (yielding)
            list.add(item)
        else if (!predicate(item)) {
            list.add(item)
            yielding = true
        }
    return list
}

/**
 * Returns a list containing all elements except first elements that satisfy the given *predicate*
 */
public inline fun <T> Iterable<T>.dropWhile(predicate: (T) -> Boolean): List<T> {
    var yielding = false
    val list = ArrayList<T>()
    for (item in this)
        if (yielding)
            list.add(item)
        else if (!predicate(item)) {
            list.add(item)
            yielding = true
        }
    return list
}

/**
 * Returns a stream containing all elements except first elements that satisfy the given *predicate*
 */
public fun <T> Stream<T>.dropWhile(predicate: (T) -> Boolean): Stream<T> {
    return DropWhileStream(this, predicate)
}

/**
 * Returns a list containing all elements except first elements that satisfy the given *predicate*
 */
public inline fun String.dropWhile(predicate: (Char) -> Boolean): String {
    for (index in 0..length - 1)
        if (!predicate(get(index))) {
            return substring(index)
        }
    return ""
}

/**
 * Returns a list containing all elements matching the given *predicate*
 */
public inline fun <T> Array<out T>.filter(predicate: (T) -> Boolean): List<T> {
    return filterTo(ArrayList<T>(), predicate)
}

/**
 * Returns a list containing all elements matching the given *predicate*
 */
public inline fun BooleanArray.filter(predicate: (Boolean) -> Boolean): List<Boolean> {
    return filterTo(ArrayList<Boolean>(), predicate)
}

/**
 * Returns a list containing all elements matching the given *predicate*
 */
public inline fun ByteArray.filter(predicate: (Byte) -> Boolean): List<Byte> {
    return filterTo(ArrayList<Byte>(), predicate)
}

/**
 * Returns a list containing all elements matching the given *predicate*
 */
public inline fun CharArray.filter(predicate: (Char) -> Boolean): List<Char> {
    return filterTo(ArrayList<Char>(), predicate)
}

/**
 * Returns a list containing all elements matching the given *predicate*
 */
public inline fun DoubleArray.filter(predicate: (Double) -> Boolean): List<Double> {
    return filterTo(ArrayList<Double>(), predicate)
}

/**
 * Returns a list containing all elements matching the given *predicate*
 */
public inline fun FloatArray.filter(predicate: (Float) -> Boolean): List<Float> {
    return filterTo(ArrayList<Float>(), predicate)
}

/**
 * Returns a list containing all elements matching the given *predicate*
 */
public inline fun IntArray.filter(predicate: (Int) -> Boolean): List<Int> {
    return filterTo(ArrayList<Int>(), predicate)
}

/**
 * Returns a list containing all elements matching the given *predicate*
 */
public inline fun LongArray.filter(predicate: (Long) -> Boolean): List<Long> {
    return filterTo(ArrayList<Long>(), predicate)
}

/**
 * Returns a list containing all elements matching the given *predicate*
 */
public inline fun ShortArray.filter(predicate: (Short) -> Boolean): List<Short> {
    return filterTo(ArrayList<Short>(), predicate)
}

/**
 * Returns a list containing all elements matching the given *predicate*
 */
public inline fun <T> Iterable<T>.filter(predicate: (T) -> Boolean): List<T> {
    return filterTo(ArrayList<T>(), predicate)
}

/**
 * Returns a stream containing all elements matching the given *predicate*
 */
public fun <T> Stream<T>.filter(predicate: (T) -> Boolean): Stream<T> {
    return FilteringStream(this, true, predicate)
}

/**
 * Returns a list containing all elements matching the given *predicate*
 */
public inline fun String.filter(predicate: (Char) -> Boolean): String {
    return filterTo(StringBuilder(), predicate).toString()
}

/**
 * Returns a list containing all elements not matching the given *predicate*
 */
public inline fun <T> Array<out T>.filterNot(predicate: (T) -> Boolean): List<T> {
    return filterNotTo(ArrayList<T>(), predicate)
}

/**
 * Returns a list containing all elements not matching the given *predicate*
 */
public inline fun BooleanArray.filterNot(predicate: (Boolean) -> Boolean): List<Boolean> {
    return filterNotTo(ArrayList<Boolean>(), predicate)
}

/**
 * Returns a list containing all elements not matching the given *predicate*
 */
public inline fun ByteArray.filterNot(predicate: (Byte) -> Boolean): List<Byte> {
    return filterNotTo(ArrayList<Byte>(), predicate)
}

/**
 * Returns a list containing all elements not matching the given *predicate*
 */
public inline fun CharArray.filterNot(predicate: (Char) -> Boolean): List<Char> {
    return filterNotTo(ArrayList<Char>(), predicate)
}

/**
 * Returns a list containing all elements not matching the given *predicate*
 */
public inline fun DoubleArray.filterNot(predicate: (Double) -> Boolean): List<Double> {
    return filterNotTo(ArrayList<Double>(), predicate)
}

/**
 * Returns a list containing all elements not matching the given *predicate*
 */
public inline fun FloatArray.filterNot(predicate: (Float) -> Boolean): List<Float> {
    return filterNotTo(ArrayList<Float>(), predicate)
}

/**
 * Returns a list containing all elements not matching the given *predicate*
 */
public inline fun IntArray.filterNot(predicate: (Int) -> Boolean): List<Int> {
    return filterNotTo(ArrayList<Int>(), predicate)
}

/**
 * Returns a list containing all elements not matching the given *predicate*
 */
public inline fun LongArray.filterNot(predicate: (Long) -> Boolean): List<Long> {
    return filterNotTo(ArrayList<Long>(), predicate)
}

/**
 * Returns a list containing all elements not matching the given *predicate*
 */
public inline fun ShortArray.filterNot(predicate: (Short) -> Boolean): List<Short> {
    return filterNotTo(ArrayList<Short>(), predicate)
}

/**
 * Returns a list containing all elements not matching the given *predicate*
 */
public inline fun <T> Iterable<T>.filterNot(predicate: (T) -> Boolean): List<T> {
    return filterNotTo(ArrayList<T>(), predicate)
}

/**
 * Returns a stream containing all elements not matching the given *predicate*
 */
public fun <T> Stream<T>.filterNot(predicate: (T) -> Boolean): Stream<T> {
    return FilteringStream(this, false, predicate)
}

/**
 * Returns a list containing all elements not matching the given *predicate*
 */
public inline fun String.filterNot(predicate: (Char) -> Boolean): String {
    return filterNotTo(StringBuilder(), predicate).toString()
}

/**
 * Returns a list containing all elements that are not null
 */
public fun <T : Any> Array<T?>.filterNotNull(): List<T> {
    return filterNotNullTo(ArrayList<T>())
}

/**
 * Returns a list containing all elements that are not null
 */
public fun <T : Any> Iterable<T?>.filterNotNull(): List<T> {
    return filterNotNullTo(ArrayList<T>())
}

/**
 * Returns a stream containing all elements that are not null
 */
public fun <T : Any> Stream<T?>.filterNotNull(): Stream<T> {
    return FilteringStream(this, false, { it == null }) as Stream<T>
}

/**
 * Appends all elements that are not null to the given *destination*
 */
public fun <C : MutableCollection<in T>, T : Any> Array<T?>.filterNotNullTo(destination: C): C {
    for (element in this) if (element != null) destination.add(element)
    return destination
}

/**
 * Appends all elements that are not null to the given *destination*
 */
public fun <C : MutableCollection<in T>, T : Any> Iterable<T?>.filterNotNullTo(destination: C): C {
    for (element in this) if (element != null) destination.add(element)
    return destination
}

/**
 * Appends all elements that are not null to the given *destination*
 */
public fun <C : MutableCollection<in T>, T : Any> Stream<T?>.filterNotNullTo(destination: C): C {
    for (element in this) if (element != null) destination.add(element)
    return destination
}

/**
 * Appends all elements not matching the given *predicate* to the given *destination*
 */
public inline fun <T, C : MutableCollection<in T>> Array<out T>.filterNotTo(destination: C, predicate: (T) -> Boolean): C {
    for (element in this) if (!predicate(element)) destination.add(element)
    return destination
}

/**
 * Appends all elements not matching the given *predicate* to the given *destination*
 */
public inline fun <C : MutableCollection<in Boolean>> BooleanArray.filterNotTo(destination: C, predicate: (Boolean) -> Boolean): C {
    for (element in this) if (!predicate(element)) destination.add(element)
    return destination
}

/**
 * Appends all elements not matching the given *predicate* to the given *destination*
 */
public inline fun <C : MutableCollection<in Byte>> ByteArray.filterNotTo(destination: C, predicate: (Byte) -> Boolean): C {
    for (element in this) if (!predicate(element)) destination.add(element)
    return destination
}

/**
 * Appends all elements not matching the given *predicate* to the given *destination*
 */
public inline fun <C : MutableCollection<in Char>> CharArray.filterNotTo(destination: C, predicate: (Char) -> Boolean): C {
    for (element in this) if (!predicate(element)) destination.add(element)
    return destination
}

/**
 * Appends all elements not matching the given *predicate* to the given *destination*
 */
public inline fun <C : MutableCollection<in Double>> DoubleArray.filterNotTo(destination: C, predicate: (Double) -> Boolean): C {
    for (element in this) if (!predicate(element)) destination.add(element)
    return destination
}

/**
 * Appends all elements not matching the given *predicate* to the given *destination*
 */
public inline fun <C : MutableCollection<in Float>> FloatArray.filterNotTo(destination: C, predicate: (Float) -> Boolean): C {
    for (element in this) if (!predicate(element)) destination.add(element)
    return destination
}

/**
 * Appends all elements not matching the given *predicate* to the given *destination*
 */
public inline fun <C : MutableCollection<in Int>> IntArray.filterNotTo(destination: C, predicate: (Int) -> Boolean): C {
    for (element in this) if (!predicate(element)) destination.add(element)
    return destination
}

/**
 * Appends all elements not matching the given *predicate* to the given *destination*
 */
public inline fun <C : MutableCollection<in Long>> LongArray.filterNotTo(destination: C, predicate: (Long) -> Boolean): C {
    for (element in this) if (!predicate(element)) destination.add(element)
    return destination
}

/**
 * Appends all elements not matching the given *predicate* to the given *destination*
 */
public inline fun <C : MutableCollection<in Short>> ShortArray.filterNotTo(destination: C, predicate: (Short) -> Boolean): C {
    for (element in this) if (!predicate(element)) destination.add(element)
    return destination
}

/**
 * Appends all elements not matching the given *predicate* to the given *destination*
 */
public inline fun <T, C : MutableCollection<in T>> Iterable<T>.filterNotTo(destination: C, predicate: (T) -> Boolean): C {
    for (element in this) if (!predicate(element)) destination.add(element)
    return destination
}

/**
 * Appends all elements not matching the given *predicate* to the given *destination*
 */
public inline fun <T, C : MutableCollection<in T>> Stream<T>.filterNotTo(destination: C, predicate: (T) -> Boolean): C {
    for (element in this) if (!predicate(element)) destination.add(element)
    return destination
}

/**
 * Appends all characters not matching the given *predicate* to the given *destination*
 */
public inline fun <C : Appendable> String.filterNotTo(destination: C, predicate: (Char) -> Boolean): C {
    for (element in this) if (!predicate(element)) destination.append(element)
    return destination
}

/**
 * Appends all elements matching the given *predicate* into the given *destination*
 */
public inline fun <T, C : MutableCollection<in T>> Array<out T>.filterTo(destination: C, predicate: (T) -> Boolean): C {
    for (element in this) if (predicate(element)) destination.add(element)
    return destination
}

/**
 * Appends all elements matching the given *predicate* into the given *destination*
 */
public inline fun <C : MutableCollection<in Boolean>> BooleanArray.filterTo(destination: C, predicate: (Boolean) -> Boolean): C {
    for (element in this) if (predicate(element)) destination.add(element)
    return destination
}

/**
 * Appends all elements matching the given *predicate* into the given *destination*
 */
public inline fun <C : MutableCollection<in Byte>> ByteArray.filterTo(destination: C, predicate: (Byte) -> Boolean): C {
    for (element in this) if (predicate(element)) destination.add(element)
    return destination
}

/**
 * Appends all elements matching the given *predicate* into the given *destination*
 */
public inline fun <C : MutableCollection<in Char>> CharArray.filterTo(destination: C, predicate: (Char) -> Boolean): C {
    for (element in this) if (predicate(element)) destination.add(element)
    return destination
}

/**
 * Appends all elements matching the given *predicate* into the given *destination*
 */
public inline fun <C : MutableCollection<in Double>> DoubleArray.filterTo(destination: C, predicate: (Double) -> Boolean): C {
    for (element in this) if (predicate(element)) destination.add(element)
    return destination
}

/**
 * Appends all elements matching the given *predicate* into the given *destination*
 */
public inline fun <C : MutableCollection<in Float>> FloatArray.filterTo(destination: C, predicate: (Float) -> Boolean): C {
    for (element in this) if (predicate(element)) destination.add(element)
    return destination
}

/**
 * Appends all elements matching the given *predicate* into the given *destination*
 */
public inline fun <C : MutableCollection<in Int>> IntArray.filterTo(destination: C, predicate: (Int) -> Boolean): C {
    for (element in this) if (predicate(element)) destination.add(element)
    return destination
}

/**
 * Appends all elements matching the given *predicate* into the given *destination*
 */
public inline fun <C : MutableCollection<in Long>> LongArray.filterTo(destination: C, predicate: (Long) -> Boolean): C {
    for (element in this) if (predicate(element)) destination.add(element)
    return destination
}

/**
 * Appends all elements matching the given *predicate* into the given *destination*
 */
public inline fun <C : MutableCollection<in Short>> ShortArray.filterTo(destination: C, predicate: (Short) -> Boolean): C {
    for (element in this) if (predicate(element)) destination.add(element)
    return destination
}

/**
 * Appends all elements matching the given *predicate* into the given *destination*
 */
public inline fun <T, C : MutableCollection<in T>> Iterable<T>.filterTo(destination: C, predicate: (T) -> Boolean): C {
    for (element in this) if (predicate(element)) destination.add(element)
    return destination
}

/**
 * Appends all elements matching the given *predicate* into the given *destination*
 */
public inline fun <T, C : MutableCollection<in T>> Stream<T>.filterTo(destination: C, predicate: (T) -> Boolean): C {
    for (element in this) if (predicate(element)) destination.add(element)
    return destination
}

/**
 * Appends all characters matching the given *predicate* to the given *destination*
 */
public inline fun <C : Appendable> String.filterTo(destination: C, predicate: (Char) -> Boolean): C {
    for (index in 0..length - 1) {
        val element = get(index)
        if (predicate(element)) destination.append(element)
    }
    return destination
}

/**
 * Returns a list containing elements at specified positions
 */
public fun <T> Array<out T>.slice(indices: Iterable<Int>): List<T> {
    val list = ArrayList<T>()
    for (index in indices) {
        list.add(get(index))
    }
    return list
}

/**
 * Returns a list containing elements at specified positions
 */
public fun BooleanArray.slice(indices: Iterable<Int>): List<Boolean> {
    val list = ArrayList<Boolean>()
    for (index in indices) {
        list.add(get(index))
    }
    return list
}

/**
 * Returns a list containing elements at specified positions
 */
public fun ByteArray.slice(indices: Iterable<Int>): List<Byte> {
    val list = ArrayList<Byte>()
    for (index in indices) {
        list.add(get(index))
    }
    return list
}

/**
 * Returns a list containing elements at specified positions
 */
public fun CharArray.slice(indices: Iterable<Int>): List<Char> {
    val list = ArrayList<Char>()
    for (index in indices) {
        list.add(get(index))
    }
    return list
}

/**
 * Returns a list containing elements at specified positions
 */
public fun DoubleArray.slice(indices: Iterable<Int>): List<Double> {
    val list = ArrayList<Double>()
    for (index in indices) {
        list.add(get(index))
    }
    return list
}

/**
 * Returns a list containing elements at specified positions
 */
public fun FloatArray.slice(indices: Iterable<Int>): List<Float> {
    val list = ArrayList<Float>()
    for (index in indices) {
        list.add(get(index))
    }
    return list
}

/**
 * Returns a list containing elements at specified positions
 */
public fun IntArray.slice(indices: Iterable<Int>): List<Int> {
    val list = ArrayList<Int>()
    for (index in indices) {
        list.add(get(index))
    }
    return list
}

/**
 * Returns a list containing elements at specified positions
 */
public fun LongArray.slice(indices: Iterable<Int>): List<Long> {
    val list = ArrayList<Long>()
    for (index in indices) {
        list.add(get(index))
    }
    return list
}

/**
 * Returns a list containing elements at specified positions
 */
public fun ShortArray.slice(indices: Iterable<Int>): List<Short> {
    val list = ArrayList<Short>()
    for (index in indices) {
        list.add(get(index))
    }
    return list
}

/**
 * Returns a list containing elements at specified positions
 */
public fun <T> List<T>.slice(indices: Iterable<Int>): List<T> {
    val list = ArrayList<T>()
    for (index in indices) {
        list.add(get(index))
    }
    return list
}

/**
 * Returns a list containing elements at specified positions
 */
public fun String.slice(indices: Iterable<Int>): String {
    val result = StringBuilder()
    for (i in indices) {
        result.append(get(i))
    }
    return result.toString()
}

/**
 * Returns a list containing first *n* elements
 */
public fun <T> Array<out T>.take(n: Int): List<T> {
    var count = 0
    val realN = if (n > size) size else n
    val list = ArrayList<T>(realN)
    for (item in this) {
        if (count++ == realN)
            break;
        list.add(item)
    }
    return list
}

/**
 * Returns a list containing first *n* elements
 */
public fun BooleanArray.take(n: Int): List<Boolean> {
    var count = 0
    val realN = if (n > size) size else n
    val list = ArrayList<Boolean>(realN)
    for (item in this) {
        if (count++ == realN)
            break;
        list.add(item)
    }
    return list
}

/**
 * Returns a list containing first *n* elements
 */
public fun ByteArray.take(n: Int): List<Byte> {
    var count = 0
    val realN = if (n > size) size else n
    val list = ArrayList<Byte>(realN)
    for (item in this) {
        if (count++ == realN)
            break;
        list.add(item)
    }
    return list
}

/**
 * Returns a list containing first *n* elements
 */
public fun CharArray.take(n: Int): List<Char> {
    var count = 0
    val realN = if (n > size) size else n
    val list = ArrayList<Char>(realN)
    for (item in this) {
        if (count++ == realN)
            break;
        list.add(item)
    }
    return list
}

/**
 * Returns a list containing first *n* elements
 */
public fun DoubleArray.take(n: Int): List<Double> {
    var count = 0
    val realN = if (n > size) size else n
    val list = ArrayList<Double>(realN)
    for (item in this) {
        if (count++ == realN)
            break;
        list.add(item)
    }
    return list
}

/**
 * Returns a list containing first *n* elements
 */
public fun FloatArray.take(n: Int): List<Float> {
    var count = 0
    val realN = if (n > size) size else n
    val list = ArrayList<Float>(realN)
    for (item in this) {
        if (count++ == realN)
            break;
        list.add(item)
    }
    return list
}

/**
 * Returns a list containing first *n* elements
 */
public fun IntArray.take(n: Int): List<Int> {
    var count = 0
    val realN = if (n > size) size else n
    val list = ArrayList<Int>(realN)
    for (item in this) {
        if (count++ == realN)
            break;
        list.add(item)
    }
    return list
}

/**
 * Returns a list containing first *n* elements
 */
public fun LongArray.take(n: Int): List<Long> {
    var count = 0
    val realN = if (n > size) size else n
    val list = ArrayList<Long>(realN)
    for (item in this) {
        if (count++ == realN)
            break;
        list.add(item)
    }
    return list
}

/**
 * Returns a list containing first *n* elements
 */
public fun ShortArray.take(n: Int): List<Short> {
    var count = 0
    val realN = if (n > size) size else n
    val list = ArrayList<Short>(realN)
    for (item in this) {
        if (count++ == realN)
            break;
        list.add(item)
    }
    return list
}

/**
 * Returns a list containing first *n* elements
 */
public fun <T> Collection<T>.take(n: Int): List<T> {
    var count = 0
    val realN = if (n > size) size else n
    val list = ArrayList<T>(realN)
    for (item in this) {
        if (count++ == realN)
            break;
        list.add(item)
    }
    return list
}

/**
 * Returns a list containing first *n* elements
 */
public fun <T> Iterable<T>.take(n: Int): List<T> {
    var count = 0
    val list = ArrayList<T>(n)
    for (item in this) {
        if (count++ == n)
            break
        list.add(item)
    }
    return list
}

/**
 * Returns a stream containing first *n* elements
 */
public fun <T> Stream<T>.take(n: Int): Stream<T> {
    return TakeStream(this, n)
}

/**
 * Returns a list containing first *n* elements
 */
public fun String.take(n: Int): String {
    return substring(0, Math.min(n, size))
}

/**
 * Returns a list containing first elements satisfying the given *predicate*
 */
public inline fun <T> Array<out T>.takeWhile(predicate: (T) -> Boolean): List<T> {
    val list = ArrayList<T>()
    for (item in this) {
        if (!predicate(item))
            break;
        list.add(item)
    }
    return list
}

/**
 * Returns a list containing first elements satisfying the given *predicate*
 */
public inline fun BooleanArray.takeWhile(predicate: (Boolean) -> Boolean): List<Boolean> {
    val list = ArrayList<Boolean>()
    for (item in this) {
        if (!predicate(item))
            break;
        list.add(item)
    }
    return list
}

/**
 * Returns a list containing first elements satisfying the given *predicate*
 */
public inline fun ByteArray.takeWhile(predicate: (Byte) -> Boolean): List<Byte> {
    val list = ArrayList<Byte>()
    for (item in this) {
        if (!predicate(item))
            break;
        list.add(item)
    }
    return list
}

/**
 * Returns a list containing first elements satisfying the given *predicate*
 */
public inline fun CharArray.takeWhile(predicate: (Char) -> Boolean): List<Char> {
    val list = ArrayList<Char>()
    for (item in this) {
        if (!predicate(item))
            break;
        list.add(item)
    }
    return list
}

/**
 * Returns a list containing first elements satisfying the given *predicate*
 */
public inline fun DoubleArray.takeWhile(predicate: (Double) -> Boolean): List<Double> {
    val list = ArrayList<Double>()
    for (item in this) {
        if (!predicate(item))
            break;
        list.add(item)
    }
    return list
}

/**
 * Returns a list containing first elements satisfying the given *predicate*
 */
public inline fun FloatArray.takeWhile(predicate: (Float) -> Boolean): List<Float> {
    val list = ArrayList<Float>()
    for (item in this) {
        if (!predicate(item))
            break;
        list.add(item)
    }
    return list
}

/**
 * Returns a list containing first elements satisfying the given *predicate*
 */
public inline fun IntArray.takeWhile(predicate: (Int) -> Boolean): List<Int> {
    val list = ArrayList<Int>()
    for (item in this) {
        if (!predicate(item))
            break;
        list.add(item)
    }
    return list
}

/**
 * Returns a list containing first elements satisfying the given *predicate*
 */
public inline fun LongArray.takeWhile(predicate: (Long) -> Boolean): List<Long> {
    val list = ArrayList<Long>()
    for (item in this) {
        if (!predicate(item))
            break;
        list.add(item)
    }
    return list
}

/**
 * Returns a list containing first elements satisfying the given *predicate*
 */
public inline fun ShortArray.takeWhile(predicate: (Short) -> Boolean): List<Short> {
    val list = ArrayList<Short>()
    for (item in this) {
        if (!predicate(item))
            break;
        list.add(item)
    }
    return list
}

/**
 * Returns a list containing first elements satisfying the given *predicate*
 */
public inline fun <T> Iterable<T>.takeWhile(predicate: (T) -> Boolean): List<T> {
    val list = ArrayList<T>()
    for (item in this) {
        if (!predicate(item))
            break;
        list.add(item)
    }
    return list
}

/**
 * Returns a stream containing first elements satisfying the given *predicate*
 */
public fun <T> Stream<T>.takeWhile(predicate: (T) -> Boolean): Stream<T> {
    return TakeWhileStream(this, predicate)
}

/**
 * Returns a list containing first elements satisfying the given *predicate*
 */
public inline fun String.takeWhile(predicate: (Char) -> Boolean): String {
    for (index in 0..length - 1)
        if (!predicate(get(index))) {
            return substring(0, index)
        }
    return this
}

