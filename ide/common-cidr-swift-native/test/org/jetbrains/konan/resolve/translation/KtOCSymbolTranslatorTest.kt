package org.jetbrains.konan.resolve.translation

import org.jetbrains.konan.resolve.symbols.objc.KtOCInterfaceSymbol

class KtOCSymbolTranslatorTest : KtSymbolTranslatorTestCase() {
    fun `test simple class translation`() {
        val file = configure("class A")
        val translatedSymbol = translator.translate(file, TestTarget.productModuleName).single() as KtOCInterfaceSymbol
        assertEquals("MyModuleA", translatedSymbol.name)
        assertFalse("state already loaded", translatedSymbol.stateLoaded)
        assertOCInterfaceSymbol(translatedSymbol, "MyModuleBase", true)
    }

    fun `test nested class translation`() {
        val file = configure("class A { class B }")
        val translatedSymbols = translator.translate(file, TestTarget.productModuleName)
        assertSize(2, translatedSymbols)
        val nestedSymbol = translatedSymbols.last() as KtOCInterfaceSymbol
        assertEquals("MyModuleAB", nestedSymbol.name)
        assertFalse("state already loaded", nestedSymbol.stateLoaded)
        assertOCInterfaceSymbol(nestedSymbol, "MyModuleBase", true)
    }
}