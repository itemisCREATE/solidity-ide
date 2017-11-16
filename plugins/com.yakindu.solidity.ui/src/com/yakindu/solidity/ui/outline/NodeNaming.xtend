package com.yakindu.solidity.ui.outline

import com.yakindu.solidity.solidity.ArrayTypeSpecifier
import com.yakindu.solidity.solidity.Block
import com.yakindu.solidity.solidity.BuildInModifier
import com.yakindu.solidity.solidity.ContractDefinition
import com.yakindu.solidity.solidity.EventDefinition
import com.yakindu.solidity.solidity.FunctionDefinition
import com.yakindu.solidity.solidity.FunctionModifier
import com.yakindu.solidity.solidity.IndexParameter
import com.yakindu.solidity.solidity.MappingTypeSpecifier
import com.yakindu.solidity.solidity.Parameter
import com.yakindu.solidity.solidity.SourceUnit
import com.yakindu.solidity.solidity.TypeSpecifier
import com.yakindu.solidity.solidity.Visibility
import org.yakindu.base.types.Type
import com.yakindu.solidity.solidity.Modifier

class NodeNaming {

	def dispatch String toName(SourceUnit source) {
		source.name + ".sol"
	}

	def dispatch String toName(ContractDefinition contract) {
		contract.name + " : contract"
	}

	def dispatch String toName(Block block) {
		"block"
	}

	def dispatch String toName(EventDefinition event) {
		event.name + " : event"
	}

	def dispatch String toName(Parameter param) {
		if (param.name !== null) {
			param.name + " : " + param.typeSpecifier.toName
		} else {
			param.typeSpecifier.toName
		}
	}

	def dispatch String toName(IndexParameter param) {
		param.name + " : " + param.typeSpecifier.toName
	}

// TODO please refactor me
	def dispatch String toName(FunctionDefinition function) {
		val buildInModifiers = function.modifier.filter [ mod |
			mod instanceof BuildInModifier && (mod as BuildInModifier).isVisibility
		].map [ buildInMod |
			buildInMod?.toName.toVisibilityNotation.toLowerCase
		].reduce[left, right|left + " " + right]

		val returnType = if (function.returnParameters.isEmpty) {
				"void"
			} else {
				function.returnParameters.map[param|param.toName].reduce [ left, right |
					left + "," + right
				];
			};
		val functionName = if (function.name === null) {
				""
			} else {
				function.name
			}

		val functionModifier = function.modifier.filter [ mod |
			!mod.isVisibility
		].map [ modifier |
			modifier?.toName.toLowerCase
		].reduce[left, right|left + " " + right]

		return buildInModifiers + " " + functionName + {
			if (functionModifier.nullOrEmpty) {
				""
			} else {
				"[" + functionModifier + "]"
			}
		} + " : (" + returnType + ")"
	}

	def dispatch boolean isVisibility(Modifier modifier) {
		false;
	}

	def dispatch boolean isVisibility(BuildInModifier modifier) {
		modifier.type === FunctionModifier.PUBLIC || modifier.type === FunctionModifier.INTERNAL ||
			modifier.type === FunctionModifier.EXTERNAL || modifier.type === FunctionModifier.PRIVATE
	}

	def dispatch String toName(BuildInModifier modifier) {
		modifier.type.toName
	}

	def dispatch String toName(FunctionModifier modifier) {
		modifier.getName
	}

	def dispatch String toName(MappingTypeSpecifier specifier) {
		val key = specifier.key.toName
		val value = specifier.value.toName
		return "(" + key + " => " + value + ")"
	}

	def dispatch String toName(ArrayTypeSpecifier specifier) {
		specifier.type.toName + "[]"
	}

	def dispatch String toName(TypeSpecifier specifier) {
		specifier.type.toName;
	}

	def dispatch String toName(Type type) {
		type.name;
	}

	def String toVisibilityNotation(Visibility visibility) {
		visibility.getName.toVisibilityNotation

	}

	def String toVisibilityNotation(String name) {
		switch (name) {
			case "PUBLIC": {
				return "+"
			}
			case "PRIVATE": {
				return "-"
			}
			case "INTERNAL": {
				return "~"
			}
			default: {
				return name
			}
		}
	}
}
