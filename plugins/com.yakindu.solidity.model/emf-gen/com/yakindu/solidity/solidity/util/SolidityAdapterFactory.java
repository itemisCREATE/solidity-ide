/**
 * (c) committers of YAKINDU
 */
package com.yakindu.solidity.solidity.util;

import com.yakindu.solidity.solidity.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.yakindu.solidity.solidity.SolidityPackage
 * @generated
 */
public class SolidityAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SolidityPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SolidityAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SolidityPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SoliditySwitch<Adapter> modelSwitch =
		new SoliditySwitch<Adapter>() {
			@Override
			public Adapter caseSolidityModel(SolidityModel object) {
				return createSolidityModelAdapter();
			}
			@Override
			public Adapter casePragmaDirective(PragmaDirective object) {
				return createPragmaDirectiveAdapter();
			}
			@Override
			public Adapter caseSuperTypeArgumentList(SuperTypeArgumentList object) {
				return createSuperTypeArgumentListAdapter();
			}
			@Override
			public Adapter caseBlock(Block object) {
				return createBlockAdapter();
			}
			@Override
			public Adapter caseModifier(Modifier object) {
				return createModifierAdapter();
			}
			@Override
			public Adapter caseBuildInModifier(BuildInModifier object) {
				return createBuildInModifierAdapter();
			}
			@Override
			public Adapter caseModifierInvocation(ModifierInvocation object) {
				return createModifierInvocationAdapter();
			}
			@Override
			public Adapter caseStatement(Statement object) {
				return createStatementAdapter();
			}
			@Override
			public Adapter caseThrowStatement(ThrowStatement object) {
				return createThrowStatementAdapter();
			}
			@Override
			public Adapter caseSimpleStatement(SimpleStatement object) {
				return createSimpleStatementAdapter();
			}
			@Override
			public Adapter casePlaceholderStatement(PlaceholderStatement object) {
				return createPlaceholderStatementAdapter();
			}
			@Override
			public Adapter caseReturnStatement(ReturnStatement object) {
				return createReturnStatementAdapter();
			}
			@Override
			public Adapter caseDeleteStatement(DeleteStatement object) {
				return createDeleteStatementAdapter();
			}
			@Override
			public Adapter caseContinueStatement(ContinueStatement object) {
				return createContinueStatementAdapter();
			}
			@Override
			public Adapter caseBreakStatement(BreakStatement object) {
				return createBreakStatementAdapter();
			}
			@Override
			public Adapter caseExpressionStatement(ExpressionStatement object) {
				return createExpressionStatementAdapter();
			}
			@Override
			public Adapter caseInlineAssemblyStatement(InlineAssemblyStatement object) {
				return createInlineAssemblyStatementAdapter();
			}
			@Override
			public Adapter caseVariableDefinition(VariableDefinition object) {
				return createVariableDefinitionAdapter();
			}
			@Override
			public Adapter caseIdentifierList(IdentifierList object) {
				return createIdentifierListAdapter();
			}
			@Override
			public Adapter caseIfStatement(IfStatement object) {
				return createIfStatementAdapter();
			}
			@Override
			public Adapter caseWhileStatement(WhileStatement object) {
				return createWhileStatementAdapter();
			}
			@Override
			public Adapter caseForStatement(ForStatement object) {
				return createForStatementAdapter();
			}
			@Override
			public Adapter caseInlineAssemblyBlock(InlineAssemblyBlock object) {
				return createInlineAssemblyBlockAdapter();
			}
			@Override
			public Adapter caseAssemblyLocalBinding(AssemblyLocalBinding object) {
				return createAssemblyLocalBindingAdapter();
			}
			@Override
			public Adapter caseAssemblyAssignment(AssemblyAssignment object) {
				return createAssemblyAssignmentAdapter();
			}
			@Override
			public Adapter caseAssemblyLabel(AssemblyLabel object) {
				return createAssemblyLabelAdapter();
			}
			@Override
			public Adapter caseFunctionalAssemblyExpression(FunctionalAssemblyExpression object) {
				return createFunctionalAssemblyExpressionAdapter();
			}
			@Override
			public Adapter caseIDLiteral(IDLiteral object) {
				return createIDLiteralAdapter();
			}
			@Override
			public Adapter caseDecimalNumberLiteral(DecimalNumberLiteral object) {
				return createDecimalNumberLiteralAdapter();
			}
			@Override
			public Adapter caseAddressLiteral(AddressLiteral object) {
				return createAddressLiteralAdapter();
			}
			@Override
			public Adapter caseNamedArgument(NamedArgument object) {
				return createNamedArgumentAdapter();
			}
			@Override
			public Adapter caseSimpleArgument(SimpleArgument object) {
				return createSimpleArgumentAdapter();
			}
			@Override
			public Adapter caseMappingTypeSpecifier(MappingTypeSpecifier object) {
				return createMappingTypeSpecifierAdapter();
			}
			@Override
			public Adapter caseArrayTypeSpecifier(ArrayTypeSpecifier object) {
				return createArrayTypeSpecifierAdapter();
			}
			@Override
			public Adapter caseTypeSpecifier(TypeSpecifier object) {
				return createTypeSpecifierAdapter();
			}
			@Override
			public Adapter caseSourceUnit(SourceUnit object) {
				return createSourceUnitAdapter();
			}
			@Override
			public Adapter casePragmaSolidityDirective(PragmaSolidityDirective object) {
				return createPragmaSolidityDirectiveAdapter();
			}
			@Override
			public Adapter casePragmaExperimentalDirective(PragmaExperimentalDirective object) {
				return createPragmaExperimentalDirectiveAdapter();
			}
			@Override
			public Adapter caseImportDirective(ImportDirective object) {
				return createImportDirectiveAdapter();
			}
			@Override
			public Adapter caseContractDefinition(ContractDefinition object) {
				return createContractDefinitionAdapter();
			}
			@Override
			public Adapter caseUsingForDeclaration(UsingForDeclaration object) {
				return createUsingForDeclarationAdapter();
			}
			@Override
			public Adapter caseTypeDefinition(TypeDefinition object) {
				return createTypeDefinitionAdapter();
			}
			@Override
			public Adapter caseStructDefinition(StructDefinition object) {
				return createStructDefinitionAdapter();
			}
			@Override
			public Adapter caseModifierDefinition(ModifierDefinition object) {
				return createModifierDefinitionAdapter();
			}
			@Override
			public Adapter caseConstructorDefinition(ConstructorDefinition object) {
				return createConstructorDefinitionAdapter();
			}
			@Override
			public Adapter caseEventDefinition(EventDefinition object) {
				return createEventDefinitionAdapter();
			}
			@Override
			public Adapter caseFunctionDefinition(FunctionDefinition object) {
				return createFunctionDefinitionAdapter();
			}
			@Override
			public Adapter caseParameter(Parameter object) {
				return createParameterAdapter();
			}
			@Override
			public Adapter caseIndexParameter(IndexParameter object) {
				return createIndexParameterAdapter();
			}
			@Override
			public Adapter caseIdentifier(Identifier object) {
				return createIdentifierAdapter();
			}
			@Override
			public Adapter caseExponentialExpression(ExponentialExpression object) {
				return createExponentialExpressionAdapter();
			}
			@Override
			public Adapter caseNumericalUnaryExpression(NumericalUnaryExpression object) {
				return createNumericalUnaryExpressionAdapter();
			}
			@Override
			public Adapter caseNewInstanceExpression(NewInstanceExpression object) {
				return createNewInstanceExpressionAdapter();
			}
			@Override
			public Adapter caseEmitExpression(EmitExpression object) {
				return createEmitExpressionAdapter();
			}
			@Override
			public Adapter caseTupleExpression(TupleExpression object) {
				return createTupleExpressionAdapter();
			}
			@Override
			public Adapter casePrimitiveValueExpression(PrimitiveValueExpression object) {
				return createPrimitiveValueExpressionAdapter();
			}
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseAnnotatableElement(AnnotatableElement object) {
				return createAnnotatableElementAdapter();
			}
			@Override
			public Adapter casePackageMember(PackageMember object) {
				return createPackageMemberAdapter();
			}
			@Override
			public Adapter caseTypedElement(TypedElement object) {
				return createTypedElementAdapter();
			}
			@Override
			public Adapter caseDeclaration(Declaration object) {
				return createDeclarationAdapter();
			}
			@Override
			public Adapter caseProperty(Property object) {
				return createPropertyAdapter();
			}
			@Override
			public Adapter caseLiteral(Literal object) {
				return createLiteralAdapter();
			}
			@Override
			public Adapter caseArgument(Argument object) {
				return createArgumentAdapter();
			}
			@Override
			public Adapter caseTypes_TypeSpecifier(org.yakindu.base.types.TypeSpecifier object) {
				return createTypes_TypeSpecifierAdapter();
			}
			@Override
			public Adapter caseDomainElement(DomainElement object) {
				return createDomainElementAdapter();
			}
			@Override
			public Adapter casePackage(org.yakindu.base.types.Package object) {
				return createPackageAdapter();
			}
			@Override
			public Adapter caseType(Type object) {
				return createTypeAdapter();
			}
			@Override
			public Adapter caseGenericElement(GenericElement object) {
				return createGenericElementAdapter();
			}
			@Override
			public Adapter caseComplexType(ComplexType object) {
				return createComplexTypeAdapter();
			}
			@Override
			public Adapter caseOperation(Operation object) {
				return createOperationAdapter();
			}
			@Override
			public Adapter caseTypes_Parameter(org.yakindu.base.types.Parameter object) {
				return createTypes_ParameterAdapter();
			}
			@Override
			public Adapter caseExpression(Expression object) {
				return createExpressionAdapter();
			}
			@Override
			public Adapter caseArgumentExpression(ArgumentExpression object) {
				return createArgumentExpressionAdapter();
			}
			@Override
			public Adapter caseFeatureCall(FeatureCall object) {
				return createFeatureCallAdapter();
			}
			@Override
			public Adapter caseExpressions_PrimitiveValueExpression(org.yakindu.base.expressions.expressions.PrimitiveValueExpression object) {
				return createExpressions_PrimitiveValueExpressionAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.SolidityModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.SolidityModel
	 * @generated
	 */
	public Adapter createSolidityModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.PragmaDirective <em>Pragma Directive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.PragmaDirective
	 * @generated
	 */
	public Adapter createPragmaDirectiveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.SuperTypeArgumentList <em>Super Type Argument List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.SuperTypeArgumentList
	 * @generated
	 */
	public Adapter createSuperTypeArgumentListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.Block <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.Block
	 * @generated
	 */
	public Adapter createBlockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.Modifier <em>Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.Modifier
	 * @generated
	 */
	public Adapter createModifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.BuildInModifier <em>Build In Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.BuildInModifier
	 * @generated
	 */
	public Adapter createBuildInModifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.ModifierInvocation <em>Modifier Invocation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.ModifierInvocation
	 * @generated
	 */
	public Adapter createModifierInvocationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.Statement
	 * @generated
	 */
	public Adapter createStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.ThrowStatement <em>Throw Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.ThrowStatement
	 * @generated
	 */
	public Adapter createThrowStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.SimpleStatement <em>Simple Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.SimpleStatement
	 * @generated
	 */
	public Adapter createSimpleStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.PlaceholderStatement <em>Placeholder Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.PlaceholderStatement
	 * @generated
	 */
	public Adapter createPlaceholderStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.ReturnStatement <em>Return Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.ReturnStatement
	 * @generated
	 */
	public Adapter createReturnStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.DeleteStatement <em>Delete Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.DeleteStatement
	 * @generated
	 */
	public Adapter createDeleteStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.ContinueStatement <em>Continue Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.ContinueStatement
	 * @generated
	 */
	public Adapter createContinueStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.BreakStatement <em>Break Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.BreakStatement
	 * @generated
	 */
	public Adapter createBreakStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.ExpressionStatement <em>Expression Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.ExpressionStatement
	 * @generated
	 */
	public Adapter createExpressionStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.InlineAssemblyStatement <em>Inline Assembly Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.InlineAssemblyStatement
	 * @generated
	 */
	public Adapter createInlineAssemblyStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.VariableDefinition <em>Variable Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.VariableDefinition
	 * @generated
	 */
	public Adapter createVariableDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.IdentifierList <em>Identifier List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.IdentifierList
	 * @generated
	 */
	public Adapter createIdentifierListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.IfStatement <em>If Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.IfStatement
	 * @generated
	 */
	public Adapter createIfStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.WhileStatement <em>While Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.WhileStatement
	 * @generated
	 */
	public Adapter createWhileStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.ForStatement <em>For Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.ForStatement
	 * @generated
	 */
	public Adapter createForStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.InlineAssemblyBlock <em>Inline Assembly Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.InlineAssemblyBlock
	 * @generated
	 */
	public Adapter createInlineAssemblyBlockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.AssemblyLocalBinding <em>Assembly Local Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.AssemblyLocalBinding
	 * @generated
	 */
	public Adapter createAssemblyLocalBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.AssemblyAssignment <em>Assembly Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.AssemblyAssignment
	 * @generated
	 */
	public Adapter createAssemblyAssignmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.AssemblyLabel <em>Assembly Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.AssemblyLabel
	 * @generated
	 */
	public Adapter createAssemblyLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.FunctionalAssemblyExpression <em>Functional Assembly Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.FunctionalAssemblyExpression
	 * @generated
	 */
	public Adapter createFunctionalAssemblyExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.IDLiteral <em>ID Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.IDLiteral
	 * @generated
	 */
	public Adapter createIDLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.DecimalNumberLiteral <em>Decimal Number Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.DecimalNumberLiteral
	 * @generated
	 */
	public Adapter createDecimalNumberLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.AddressLiteral <em>Address Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.AddressLiteral
	 * @generated
	 */
	public Adapter createAddressLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.NamedArgument <em>Named Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.NamedArgument
	 * @generated
	 */
	public Adapter createNamedArgumentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.SimpleArgument <em>Simple Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.SimpleArgument
	 * @generated
	 */
	public Adapter createSimpleArgumentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.MappingTypeSpecifier <em>Mapping Type Specifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.MappingTypeSpecifier
	 * @generated
	 */
	public Adapter createMappingTypeSpecifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.ArrayTypeSpecifier <em>Array Type Specifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.ArrayTypeSpecifier
	 * @generated
	 */
	public Adapter createArrayTypeSpecifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.TypeSpecifier <em>Type Specifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.TypeSpecifier
	 * @generated
	 */
	public Adapter createTypeSpecifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.SourceUnit <em>Source Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.SourceUnit
	 * @generated
	 */
	public Adapter createSourceUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.PragmaSolidityDirective <em>Pragma Solidity Directive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.PragmaSolidityDirective
	 * @generated
	 */
	public Adapter createPragmaSolidityDirectiveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.PragmaExperimentalDirective <em>Pragma Experimental Directive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.PragmaExperimentalDirective
	 * @generated
	 */
	public Adapter createPragmaExperimentalDirectiveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.ImportDirective <em>Import Directive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.ImportDirective
	 * @generated
	 */
	public Adapter createImportDirectiveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.ContractDefinition <em>Contract Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.ContractDefinition
	 * @generated
	 */
	public Adapter createContractDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.UsingForDeclaration <em>Using For Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.UsingForDeclaration
	 * @generated
	 */
	public Adapter createUsingForDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.TypeDefinition <em>Type Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.TypeDefinition
	 * @generated
	 */
	public Adapter createTypeDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.StructDefinition <em>Struct Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.StructDefinition
	 * @generated
	 */
	public Adapter createStructDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.ModifierDefinition <em>Modifier Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.ModifierDefinition
	 * @generated
	 */
	public Adapter createModifierDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.ConstructorDefinition <em>Constructor Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.ConstructorDefinition
	 * @generated
	 */
	public Adapter createConstructorDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.EventDefinition <em>Event Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.EventDefinition
	 * @generated
	 */
	public Adapter createEventDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.FunctionDefinition <em>Function Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.FunctionDefinition
	 * @generated
	 */
	public Adapter createFunctionDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.Parameter
	 * @generated
	 */
	public Adapter createParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.IndexParameter <em>Index Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.IndexParameter
	 * @generated
	 */
	public Adapter createIndexParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.Identifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.Identifier
	 * @generated
	 */
	public Adapter createIdentifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.ExponentialExpression <em>Exponential Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.ExponentialExpression
	 * @generated
	 */
	public Adapter createExponentialExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.NumericalUnaryExpression <em>Numerical Unary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.NumericalUnaryExpression
	 * @generated
	 */
	public Adapter createNumericalUnaryExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.NewInstanceExpression <em>New Instance Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.NewInstanceExpression
	 * @generated
	 */
	public Adapter createNewInstanceExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.EmitExpression <em>Emit Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.EmitExpression
	 * @generated
	 */
	public Adapter createEmitExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.TupleExpression <em>Tuple Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.TupleExpression
	 * @generated
	 */
	public Adapter createTupleExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.yakindu.solidity.solidity.PrimitiveValueExpression <em>Primitive Value Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.yakindu.solidity.solidity.PrimitiveValueExpression
	 * @generated
	 */
	public Adapter createPrimitiveValueExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.base.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.base.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.types.AnnotatableElement <em>Annotatable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.types.AnnotatableElement
	 * @generated
	 */
	public Adapter createAnnotatableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.types.PackageMember <em>Package Member</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.types.PackageMember
	 * @generated
	 */
	public Adapter createPackageMemberAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.types.TypedElement <em>Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.types.TypedElement
	 * @generated
	 */
	public Adapter createTypedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.types.Declaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.types.Declaration
	 * @generated
	 */
	public Adapter createDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.types.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.types.Property
	 * @generated
	 */
	public Adapter createPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.expressions.expressions.Literal <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.expressions.expressions.Literal
	 * @generated
	 */
	public Adapter createLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.expressions.expressions.Argument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.expressions.expressions.Argument
	 * @generated
	 */
	public Adapter createArgumentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.types.TypeSpecifier <em>Type Specifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.types.TypeSpecifier
	 * @generated
	 */
	public Adapter createTypes_TypeSpecifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.base.DomainElement <em>Domain Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.base.DomainElement
	 * @generated
	 */
	public Adapter createDomainElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.types.Package <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.types.Package
	 * @generated
	 */
	public Adapter createPackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.types.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.types.Type
	 * @generated
	 */
	public Adapter createTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.types.GenericElement <em>Generic Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.types.GenericElement
	 * @generated
	 */
	public Adapter createGenericElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.types.ComplexType <em>Complex Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.types.ComplexType
	 * @generated
	 */
	public Adapter createComplexTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.types.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.types.Operation
	 * @generated
	 */
	public Adapter createOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.types.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.types.Parameter
	 * @generated
	 */
	public Adapter createTypes_ParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.expressions.expressions.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.expressions.expressions.Expression
	 * @generated
	 */
	public Adapter createExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.expressions.expressions.ArgumentExpression <em>Argument Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.expressions.expressions.ArgumentExpression
	 * @generated
	 */
	public Adapter createArgumentExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.expressions.expressions.FeatureCall <em>Feature Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.expressions.expressions.FeatureCall
	 * @generated
	 */
	public Adapter createFeatureCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.expressions.expressions.PrimitiveValueExpression <em>Primitive Value Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.expressions.expressions.PrimitiveValueExpression
	 * @generated
	 */
	public Adapter createExpressions_PrimitiveValueExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //SolidityAdapterFactory
