/*
 * Copyright 2010-2022 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

import objcnames.protocols.__darwin_fp_control

open class C<T : kotlinx.cinterop.ObjCObject>

class D : C<__darwin_fp_control>()

fun main() {
    println(D())
}