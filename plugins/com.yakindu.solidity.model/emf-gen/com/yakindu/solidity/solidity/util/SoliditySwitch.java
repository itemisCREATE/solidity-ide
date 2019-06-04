/**
 * (c) committers of YAKINDU
 */
package com.yakindu.solidity.solidity.util;

import com.yakindu.solidity.solidity.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.yakindu.base.base.DomainElement;
import org.yakindu.base.base.NamedElement;

import org.yakindu.base.expressions.expressions.Argument;
import org.yakindu.base.expressions.expressions.ArgumentExpression;
import org.yakindu.base.expressions.expressions.Expression;
import org.yakindu.base.expressions.expressions.FeatureCall;
import org.yakindu.base.expressions.expressions.Literal;

import org.yakindu.base.types.AnnotatableElement;
import org.yakindu.base.types.ComplexType;
import org.yakindu.base.types.Declaration;
import org.yakindu.base.types.GenericElement;
import org.yakindu.base.types.Operation;
import org.yakindu.base.types.PackageMember;
import org.yakindu.base.types.Property;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypedElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.yakindu.solidity.solidity.SolidityPackage
 * @generated
 */
public class SoliditySwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SolidityPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SoliditySwitch() {
		if (modelPackage == null) {
			modelPackage = SolidityPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case SolidityPackage.SOLIDITY_MODEL: {
				SolidityModel solidityModel = (SolidityModel)theEObject;
				T result = caseSolidityModel(solidityModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.PRAGMA_DIRECTIVE: {
				PragmaDirective pragmaDirective = (PragmaDirective)theEObject;
				T result = casePragmaDirective(pragmaDirective);
				if (result == null) result = casePackageMember(pragmaDirective);
				if (result == null) result = caseNamedElement(pragmaDirective);
				if (result == null) result = caseAnnotatableElement(pragmaDirective);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.SUPER_TYPE_ARGUMENT_LIST: {
				SuperTypeArgumentList superTypeArgumentList = (SuperTypeArgumentList)theEObject;
				T result = caseSuperTypeArgumentList(superTypeArgumentList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.BLOCK: {
				Block block = (Block)theEObject;
				T result = caseBlock(block);
				if (result == null) result = caseStatement(block);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.MODIFIER: {
				Modifier modifier = (Modifier)theEObject;
				T result = caseModifier(modifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.BUILD_IN_MODIFIER: {
				BuildInModifier buildInModifier = (BuildInModifier)theEObject;
				T result = caseBuildInModifier(buildInModifier);
				if (result == null) result = caseModifier(buildInModifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.MODIFIER_INVOCATION: {
				ModifierInvocation modifierInvocation = (ModifierInvocation)theEObject;
				T result = caseModifierInvocation(modifierInvocation);
				if (result == null) result = caseModifier(modifierInvocation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.STATEMENT: {
				Statement statement = (Statement)theEObject;
				T result = caseStatement(statement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.THROW_STATEMENT: {
				ThrowStatement throwStatement = (ThrowStatement)theEObject;
				T result = caseThrowStatement(throwStatement);
				if (result == null) result = caseStatement(throwStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.SIMPLE_STATEMENT: {
				SimpleStatement simpleStatement = (SimpleStatement)theEObject;
				T result = caseSimpleStatement(simpleStatement);
				if (result == null) result = caseStatement(simpleStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.PLACEHOLDER_STATEMENT: {
				PlaceholderStatement placeholderStatement = (PlaceholderStatement)theEObject;
				T result = casePlaceholderStatement(placeholderStatement);
				if (result == null) result = caseStatement(placeholderStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.RETURN_STATEMENT: {
				ReturnStatement returnStatement = (ReturnStatement)theEObject;
				T result = caseReturnStatement(returnStatement);
				if (result == null) result = caseStatement(returnStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.DELETE_STATEMENT: {
				DeleteStatement deleteStatement = (DeleteStatement)theEObject;
				T result = caseDeleteStatement(deleteStatement);
				if (result == null) result = caseStatement(deleteStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.CONTINUE_STATEMENT: {
				ContinueStatement continueStatement = (ContinueStatement)theEObject;
				T result = caseContinueStatement(continueStatement);
				if (result == null) result = caseStatement(continueStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.BREAK_STATEMENT: {
				BreakStatement breakStatement = (BreakStatement)theEObject;
				T result = caseBreakStatement(breakStatement);
				if (result == null) result = caseStatement(breakStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.EXPRESSION_STATEMENT: {
				ExpressionStatement expressionStatement = (ExpressionStatement)theEObject;
				T result = caseExpressionStatement(expressionStatement);
				if (result == null) result = caseSimpleStatement(expressionStatement);
				if (result == null) result = caseStatement(expressionStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.INLINE_ASSEMBLY_STATEMENT: {
				InlineAssemblyStatement inlineAssemblyStatement = (InlineAssemblyStatement)theEObject;
				T result = caseInlineAssemblyStatement(inlineAssemblyStatement);
				if (result == null) result = caseStatement(inlineAssemblyStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.VARIABLE_DEFINITION: {
				VariableDefinition variableDefinition = (VariableDefinition)theEObject;
				T result = caseVariableDefinition(variableDefinition);
				if (result == null) result = caseProperty(variableDefinition);
				if (result == null) result = caseSimpleStatement(variableDefinition);
				if (result == null) result = caseDeclaration(variableDefinition);
				if (result == null) result = caseStatement(variableDefinition);
				if (result == null) result = caseTypedElement(variableDefinition);
				if (result == null) result = casePackageMember(variableDefinition);
				if (result == null) result = caseNamedElement(variableDefinition);
				if (result == null) result = caseAnnotatableElement(variableDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.IDENTIFIER_LIST: {
				IdentifierList identifierList = (IdentifierList)theEObject;
				T result = caseIdentifierList(identifierList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.IF_STATEMENT: {
				IfStatement ifStatement = (IfStatement)theEObject;
				T result = caseIfStatement(ifStatement);
				if (result == null) result = caseStatement(ifStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.WHILE_STATEMENT: {
				WhileStatement whileStatement = (WhileStatement)theEObject;
				T result = caseWhileStatement(whileStatement);
				if (result == null) result = caseStatement(whileStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.FOR_STATEMENT: {
				ForStatement forStatement = (ForStatement)theEObject;
				T result = caseForStatement(forStatement);
				if (result == null) result = caseStatement(forStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.INLINE_ASSEMBLY_BLOCK: {
				InlineAssemblyBlock inlineAssemblyBlock = (InlineAssemblyBlock)theEObject;
				T result = caseInlineAssemblyBlock(inlineAssemblyBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.ASSEMBLY_LOCAL_BINDING: {
				AssemblyLocalBinding assemblyLocalBinding = (AssemblyLocalBinding)theEObject;
				T result = caseAssemblyLocalBinding(assemblyLocalBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.ASSEMBLY_ASSIGNMENT: {
				AssemblyAssignment assemblyAssignment = (AssemblyAssignment)theEObject;
				T result = caseAssemblyAssignment(assemblyAssignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.ASSEMBLY_LABEL: {
				AssemblyLabel assemblyLabel = (AssemblyLabel)theEObject;
				T result = caseAssemblyLabel(assemblyLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.FUNCTIONAL_ASSEMBLY_EXPRESSION: {
				FunctionalAssemblyExpression functionalAssemblyExpression = (FunctionalAssemblyExpression)theEObject;
				T result = caseFunctionalAssemblyExpression(functionalAssemblyExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.ID_LITERAL: {
				IDLiteral idLiteral = (IDLiteral)theEObject;
				T result = caseIDLiteral(idLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.DECIMAL_NUMBER_LITERAL: {
				DecimalNumberLiteral decimalNumberLiteral = (DecimalNumberLiteral)theEObject;
				T result = caseDecimalNumberLiteral(decimalNumberLiteral);
				if (result == null) result = caseLiteral(decimalNumberLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.ADDRESS_LITERAL: {
				AddressLiteral addressLiteral = (AddressLiteral)theEObject;
				T result = caseAddressLiteral(addressLiteral);
				if (result == null) result = caseLiteral(addressLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.NAMED_ARGUMENT: {
				NamedArgument namedArgument = (NamedArgument)theEObject;
				T result = caseNamedArgument(namedArgument);
				if (result == null) result = caseArgument(namedArgument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.SIMPLE_ARGUMENT: {
				SimpleArgument simpleArgument = (SimpleArgument)theEObject;
				T result = caseSimpleArgument(simpleArgument);
				if (result == null) result = caseArgument(simpleArgument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.MAPPING_TYPE_SPECIFIER: {
				MappingTypeSpecifier mappingTypeSpecifier = (MappingTypeSpecifier)theEObject;
				T result = caseMappingTypeSpecifier(mappingTypeSpecifier);
				if (result == null) result = caseTypes_TypeSpecifier(mappingTypeSpecifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.ARRAY_TYPE_SPECIFIER: {
				ArrayTypeSpecifier arrayTypeSpecifier = (ArrayTypeSpecifier)theEObject;
				T result = caseArrayTypeSpecifier(arrayTypeSpecifier);
				if (result == null) result = caseTypes_TypeSpecifier(arrayTypeSpecifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.TYPE_SPECIFIER: {
				TypeSpecifier typeSpecifier = (TypeSpecifier)theEObject;
				T result = caseTypeSpecifier(typeSpecifier);
				if (result == null) result = caseTypes_TypeSpecifier(typeSpecifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.SOURCE_UNIT: {
				SourceUnit sourceUnit = (SourceUnit)theEObject;
				T result = caseSourceUnit(sourceUnit);
				if (result == null) result = casePackage(sourceUnit);
				if (result == null) result = casePackageMember(sourceUnit);
				if (result == null) result = caseDomainElement(sourceUnit);
				if (result == null) result = caseNamedElement(sourceUnit);
				if (result == null) result = caseAnnotatableElement(sourceUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.PRAGMA_SOLIDITY_DIRECTIVE: {
				PragmaSolidityDirective pragmaSolidityDirective = (PragmaSolidityDirective)theEObject;
				T result = casePragmaSolidityDirective(pragmaSolidityDirective);
				if (result == null) result = casePragmaDirective(pragmaSolidityDirective);
				if (result == null) result = casePackageMember(pragmaSolidityDirective);
				if (result == null) result = caseNamedElement(pragmaSolidityDirective);
				if (result == null) result = caseAnnotatableElement(pragmaSolidityDirective);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.PRAGMA_EXPERIMENTAL_DIRECTIVE: {
				PragmaExperimentalDirective pragmaExperimentalDirective = (PragmaExperimentalDirective)theEObject;
				T result = casePragmaExperimentalDirective(pragmaExperimentalDirective);
				if (result == null) result = casePragmaDirective(pragmaExperimentalDirective);
				if (result == null) result = casePackageMember(pragmaExperimentalDirective);
				if (result == null) result = caseNamedElement(pragmaExperimentalDirective);
				if (result == null) result = caseAnnotatableElement(pragmaExperimentalDirective);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.IMPORT_DIRECTIVE: {
				ImportDirective importDirective = (ImportDirective)theEObject;
				T result = caseImportDirective(importDirective);
				if (result == null) result = casePackageMember(importDirective);
				if (result == null) result = caseNamedElement(importDirective);
				if (result == null) result = caseAnnotatableElement(importDirective);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.CONTRACT_DEFINITION: {
				ContractDefinition contractDefinition = (ContractDefinition)theEObject;
				T result = caseContractDefinition(contractDefinition);
				if (result == null) result = caseComplexType(contractDefinition);
				if (result == null) result = caseType(contractDefinition);
				if (result == null) result = caseGenericElement(contractDefinition);
				if (result == null) result = casePackageMember(contractDefinition);
				if (result == null) result = caseNamedElement(contractDefinition);
				if (result == null) result = caseAnnotatableElement(contractDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.USING_FOR_DECLARATION: {
				UsingForDeclaration usingForDeclaration = (UsingForDeclaration)theEObject;
				T result = caseUsingForDeclaration(usingForDeclaration);
				if (result == null) result = caseDeclaration(usingForDeclaration);
				if (result == null) result = caseTypedElement(usingForDeclaration);
				if (result == null) result = casePackageMember(usingForDeclaration);
				if (result == null) result = caseNamedElement(usingForDeclaration);
				if (result == null) result = caseAnnotatableElement(usingForDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.TYPE_DEFINITION: {
				TypeDefinition typeDefinition = (TypeDefinition)theEObject;
				T result = caseTypeDefinition(typeDefinition);
				if (result == null) result = caseDeclaration(typeDefinition);
				if (result == null) result = caseTypedElement(typeDefinition);
				if (result == null) result = casePackageMember(typeDefinition);
				if (result == null) result = caseNamedElement(typeDefinition);
				if (result == null) result = caseAnnotatableElement(typeDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.STRUCT_DEFINITION: {
				StructDefinition structDefinition = (StructDefinition)theEObject;
				T result = caseStructDefinition(structDefinition);
				if (result == null) result = caseComplexType(structDefinition);
				if (result == null) result = caseType(structDefinition);
				if (result == null) result = caseGenericElement(structDefinition);
				if (result == null) result = casePackageMember(structDefinition);
				if (result == null) result = caseNamedElement(structDefinition);
				if (result == null) result = caseAnnotatableElement(structDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.MODIFIER_DEFINITION: {
				ModifierDefinition modifierDefinition = (ModifierDefinition)theEObject;
				T result = caseModifierDefinition(modifierDefinition);
				if (result == null) result = caseOperation(modifierDefinition);
				if (result == null) result = caseDeclaration(modifierDefinition);
				if (result == null) result = caseGenericElement(modifierDefinition);
				if (result == null) result = caseTypedElement(modifierDefinition);
				if (result == null) result = casePackageMember(modifierDefinition);
				if (result == null) result = caseNamedElement(modifierDefinition);
				if (result == null) result = caseAnnotatableElement(modifierDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.CONSTRUCTOR_DEFINITION: {
				ConstructorDefinition constructorDefinition = (ConstructorDefinition)theEObject;
				T result = caseConstructorDefinition(constructorDefinition);
				if (result == null) result = caseOperation(constructorDefinition);
				if (result == null) result = caseDeclaration(constructorDefinition);
				if (result == null) result = caseGenericElement(constructorDefinition);
				if (result == null) result = caseTypedElement(constructorDefinition);
				if (result == null) result = casePackageMember(constructorDefinition);
				if (result == null) result = caseNamedElement(constructorDefinition);
				if (result == null) result = caseAnnotatableElement(constructorDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.EVENT_DEFINITION: {
				EventDefinition eventDefinition = (EventDefinition)theEObject;
				T result = caseEventDefinition(eventDefinition);
				if (result == null) result = caseOperation(eventDefinition);
				if (result == null) result = caseDeclaration(eventDefinition);
				if (result == null) result = caseGenericElement(eventDefinition);
				if (result == null) result = caseTypedElement(eventDefinition);
				if (result == null) result = casePackageMember(eventDefinition);
				if (result == null) result = caseNamedElement(eventDefinition);
				if (result == null) result = caseAnnotatableElement(eventDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.FUNCTION_DEFINITION: {
				FunctionDefinition functionDefinition = (FunctionDefinition)theEObject;
				T result = caseFunctionDefinition(functionDefinition);
				if (result == null) result = caseOperation(functionDefinition);
				if (result == null) result = caseDeclaration(functionDefinition);
				if (result == null) result = caseGenericElement(functionDefinition);
				if (result == null) result = caseTypedElement(functionDefinition);
				if (result == null) result = casePackageMember(functionDefinition);
				if (result == null) result = caseNamedElement(functionDefinition);
				if (result == null) result = caseAnnotatableElement(functionDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.PARAMETER: {
				Parameter parameter = (Parameter)theEObject;
				T result = caseParameter(parameter);
				if (result == null) result = caseTypes_Parameter(parameter);
				if (result == null) result = caseTypedElement(parameter);
				if (result == null) result = caseNamedElement(parameter);
				if (result == null) result = caseAnnotatableElement(parameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.INDEX_PARAMETER: {
				IndexParameter indexParameter = (IndexParameter)theEObject;
				T result = caseIndexParameter(indexParameter);
				if (result == null) result = caseTypes_Parameter(indexParameter);
				if (result == null) result = caseTypedElement(indexParameter);
				if (result == null) result = caseNamedElement(indexParameter);
				if (result == null) result = caseAnnotatableElement(indexParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.IDENTIFIER: {
				Identifier identifier = (Identifier)theEObject;
				T result = caseIdentifier(identifier);
				if (result == null) result = caseDeclaration(identifier);
				if (result == null) result = caseTypedElement(identifier);
				if (result == null) result = casePackageMember(identifier);
				if (result == null) result = caseNamedElement(identifier);
				if (result == null) result = caseAnnotatableElement(identifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.EXPONENTIAL_EXPRESSION: {
				ExponentialExpression exponentialExpression = (ExponentialExpression)theEObject;
				T result = caseExponentialExpression(exponentialExpression);
				if (result == null) result = caseExpression(exponentialExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.NUMERICAL_UNARY_EXPRESSION: {
				NumericalUnaryExpression numericalUnaryExpression = (NumericalUnaryExpression)theEObject;
				T result = caseNumericalUnaryExpression(numericalUnaryExpression);
				if (result == null) result = caseExpression(numericalUnaryExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.NEW_INSTANCE_EXPRESSION: {
				NewInstanceExpression newInstanceExpression = (NewInstanceExpression)theEObject;
				T result = caseNewInstanceExpression(newInstanceExpression);
				if (result == null) result = caseFeatureCall(newInstanceExpression);
				if (result == null) result = caseArgumentExpression(newInstanceExpression);
				if (result == null) result = caseExpression(newInstanceExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.EMIT_EXPRESSION: {
				EmitExpression emitExpression = (EmitExpression)theEObject;
				T result = caseEmitExpression(emitExpression);
				if (result == null) result = caseFeatureCall(emitExpression);
				if (result == null) result = caseArgumentExpression(emitExpression);
				if (result == null) result = caseExpression(emitExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.TUPLE_EXPRESSION: {
				TupleExpression tupleExpression = (TupleExpression)theEObject;
				T result = caseTupleExpression(tupleExpression);
				if (result == null) result = caseExpression(tupleExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SolidityPackage.PRIMITIVE_VALUE_EXPRESSION: {
				PrimitiveValueExpression primitiveValueExpression = (PrimitiveValueExpression)theEObject;
				T result = casePrimitiveValueExpression(primitiveValueExpression);
				if (result == null) result = caseExpressions_PrimitiveValueExpression(primitiveValueExpression);
				if (result == null) result = caseExpression(primitiveValueExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSolidityModel(SolidityModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pragma Directive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pragma Directive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePragmaDirective(PragmaDirective object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Super Type Argument List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Super Type Argument List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSuperTypeArgumentList(SuperTypeArgumentList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlock(Block object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Modifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Modifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModifier(Modifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Build In Modifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Build In Modifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBuildInModifier(BuildInModifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Modifier Invocation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Modifier Invocation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModifierInvocation(ModifierInvocation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatement(Statement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Throw Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Throw Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThrowStatement(ThrowStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleStatement(SimpleStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Placeholder Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Placeholder Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlaceholderStatement(PlaceholderStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Return Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Return Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReturnStatement(ReturnStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Delete Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delete Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeleteStatement(DeleteStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Continue Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Continue Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContinueStatement(ContinueStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Break Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Break Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBreakStatement(BreakStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionStatement(ExpressionStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inline Assembly Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inline Assembly Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInlineAssemblyStatement(InlineAssemblyStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableDefinition(VariableDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifier List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifier List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifierList(IdentifierList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>If Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfStatement(IfStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>While Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>While Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWhileStatement(WhileStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>For Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>For Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForStatement(ForStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inline Assembly Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inline Assembly Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInlineAssemblyBlock(InlineAssemblyBlock object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assembly Local Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assembly Local Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssemblyLocalBinding(AssemblyLocalBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assembly Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assembly Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssemblyAssignment(AssemblyAssignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assembly Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assembly Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssemblyLabel(AssemblyLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Functional Assembly Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Functional Assembly Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionalAssemblyExpression(FunctionalAssemblyExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ID Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ID Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIDLiteral(IDLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Decimal Number Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Decimal Number Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDecimalNumberLiteral(DecimalNumberLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Address Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Address Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddressLiteral(AddressLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Argument</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Argument</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedArgument(NamedArgument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Argument</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Argument</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleArgument(SimpleArgument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Type Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Type Specifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingTypeSpecifier(MappingTypeSpecifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Array Type Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Array Type Specifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArrayTypeSpecifier(ArrayTypeSpecifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Specifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeSpecifier(TypeSpecifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Source Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSourceUnit(SourceUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pragma Solidity Directive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pragma Solidity Directive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePragmaSolidityDirective(PragmaSolidityDirective object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pragma Experimental Directive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pragma Experimental Directive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePragmaExperimentalDirective(PragmaExperimentalDirective object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Import Directive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Import Directive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImportDirective(ImportDirective object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Contract Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Contract Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContractDefinition(ContractDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Using For Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Using For Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUsingForDeclaration(UsingForDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeDefinition(TypeDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Struct Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Struct Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructDefinition(StructDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Modifier Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Modifier Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModifierDefinition(ModifierDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constructor Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constructor Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstructorDefinition(ConstructorDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventDefinition(EventDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionDefinition(FunctionDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameter(Parameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Index Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Index Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIndexParameter(IndexParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifier(Identifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exponential Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exponential Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExponentialExpression(ExponentialExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Numerical Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Numerical Unary Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNumericalUnaryExpression(NumericalUnaryExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>New Instance Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>New Instance Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNewInstanceExpression(NewInstanceExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Emit Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Emit Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEmitExpression(EmitExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tuple Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tuple Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTupleExpression(TupleExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Value Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Value Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveValueExpression(PrimitiveValueExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotatable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotatable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnotatableElement(AnnotatableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package Member</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package Member</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackageMember(PackageMember object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedElement(TypedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeclaration(Declaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProperty(Property object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteral(Literal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Argument</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Argument</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArgument(Argument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Specifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypes_TypeSpecifier(org.yakindu.base.types.TypeSpecifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Domain Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Domain Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDomainElement(DomainElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackage(org.yakindu.base.types.Package object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseType(Type object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generic Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generic Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenericElement(GenericElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Complex Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Complex Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComplexType(ComplexType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperation(Operation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypes_Parameter(org.yakindu.base.types.Parameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpression(Expression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Argument Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Argument Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArgumentExpression(ArgumentExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureCall(FeatureCall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Value Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Value Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressions_PrimitiveValueExpression(org.yakindu.base.expressions.expressions.PrimitiveValueExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //SoliditySwitch
