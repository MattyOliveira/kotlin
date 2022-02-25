/*
 * Copyright 2010-2016 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.psi2ir.generators

import org.jetbrains.kotlin.builtins.StandardNames.ENUM_VALUES
import org.jetbrains.kotlin.builtins.StandardNames.ENUM_VALUE_OF
import org.jetbrains.kotlin.ir.declarations.IrClass
import org.jetbrains.kotlin.ir.declarations.IrDeclarationOrigin
import org.jetbrains.kotlin.ir.declarations.addMember
import org.jetbrains.kotlin.ir.expressions.IrSyntheticBodyKind
import org.jetbrains.kotlin.ir.expressions.impl.IrBlockBodyImpl
import org.jetbrains.kotlin.ir.util.SYNTHETIC_OFFSET
import org.jetbrains.kotlin.ir.util.declareSimpleFunctionWithOverrides
import org.jetbrains.kotlin.resolve.scopes.findFirstFunction

class EnumClassMembersGenerator(declarationGenerator: DeclarationGenerator) : DeclarationGeneratorExtension(declarationGenerator) {
    fun generateSpecialMembers(irClass: IrClass) {
        generateValues(irClass)
        generateValueOf(irClass)
    }

    private fun generateValues(irClass: IrClass) {
        val valuesFunction = irClass.descriptor.staticScope.findFirstFunction(ENUM_VALUES.identifier) {
            it.dispatchReceiverParameter == null &&
                    it.extensionReceiverParameter == null &&
                    it.valueParameters.size == 0
        }

        irClass.addMember(
            context.symbolTable.declareSimpleFunctionWithOverrides(
                SYNTHETIC_OFFSET, SYNTHETIC_OFFSET,
                IrDeclarationOrigin.ENUM_CLASS_SPECIAL_MEMBER_ENUM_VALUES,
                valuesFunction
            ).also { irFunction ->
                FunctionGenerator(declarationGenerator).generateFunctionParameterDeclarationsAndReturnType(irFunction, null, null, emptyList())
                //irFunction.body = IrBlockBodyImpl(SYNTHETIC_OFFSET, SYNTHETIC_OFFSET, emptyList())
            }
        )
    }

    private fun generateValueOf(irClass: IrClass) {
        val valueOfFunction = irClass.descriptor.staticScope.findFirstFunction(ENUM_VALUE_OF.identifier) {
            it.dispatchReceiverParameter == null &&
                    it.extensionReceiverParameter == null &&
                    it.valueParameters.size == 1
        }

        irClass.addMember(
            context.symbolTable.declareSimpleFunctionWithOverrides(
                SYNTHETIC_OFFSET, SYNTHETIC_OFFSET,
                IrDeclarationOrigin.ENUM_CLASS_SPECIAL_MEMBER_VALUES_OF,
                valueOfFunction
            ).also { irFunction ->
                FunctionGenerator(declarationGenerator).generateFunctionParameterDeclarationsAndReturnType(irFunction, null, null, emptyList())
                //irFunction.body = IrBlockBodyImpl(SYNTHETIC_OFFSET, SYNTHETIC_OFFSET, emptyList())
            }
        )
    }
}
