/**
 * (c) committers of YAKINDU
 */
package com.yakindu.solidity.solidity.impl;

import com.yakindu.solidity.solidity.AddressLiteral;
import com.yakindu.solidity.solidity.ArrayTypeSpecifier;
import com.yakindu.solidity.solidity.AssemblyAssignment;
import com.yakindu.solidity.solidity.AssemblyKind;
import com.yakindu.solidity.solidity.AssemblyLabel;
import com.yakindu.solidity.solidity.AssemblyLocalBinding;
import com.yakindu.solidity.solidity.Block;
import com.yakindu.solidity.solidity.BreakStatement;
import com.yakindu.solidity.solidity.BuildInModifier;
import com.yakindu.solidity.solidity.ConstructorDefinition;
import com.yakindu.solidity.solidity.ContinueStatement;
import com.yakindu.solidity.solidity.ContractDefinition;
import com.yakindu.solidity.solidity.ContractType;
import com.yakindu.solidity.solidity.DecimalNumberLiteral;
import com.yakindu.solidity.solidity.DeleteStatement;
import com.yakindu.solidity.solidity.EmitExpression;
import com.yakindu.solidity.solidity.EventDefinition;
import com.yakindu.solidity.solidity.ExponentialExpression;
import com.yakindu.solidity.solidity.ExpressionStatement;
import com.yakindu.solidity.solidity.ForStatement;
import com.yakindu.solidity.solidity.FunctionDefinition;
import com.yakindu.solidity.solidity.FunctionModifier;
import com.yakindu.solidity.solidity.FunctionalAssemblyExpression;
import com.yakindu.solidity.solidity.IDLiteral;
import com.yakindu.solidity.solidity.Identifier;
import com.yakindu.solidity.solidity.IdentifierList;
import com.yakindu.solidity.solidity.IfStatement;
import com.yakindu.solidity.solidity.ImportDirective;
import com.yakindu.solidity.solidity.IndexParameter;
import com.yakindu.solidity.solidity.InlineAssemblyBlock;
import com.yakindu.solidity.solidity.InlineAssemblyStatement;
import com.yakindu.solidity.solidity.MappingTypeSpecifier;
import com.yakindu.solidity.solidity.Modifier;
import com.yakindu.solidity.solidity.ModifierDefinition;
import com.yakindu.solidity.solidity.ModifierInvocation;
import com.yakindu.solidity.solidity.NamedArgument;
import com.yakindu.solidity.solidity.NewInstanceExpression;
import com.yakindu.solidity.solidity.NumericalUnaryExpression;
import com.yakindu.solidity.solidity.Parameter;
import com.yakindu.solidity.solidity.PlaceholderStatement;
import com.yakindu.solidity.solidity.PragmaDirective;
import com.yakindu.solidity.solidity.PragmaExperimentalDirective;
import com.yakindu.solidity.solidity.PragmaSolidityDirective;
import com.yakindu.solidity.solidity.PrimitiveValueExpression;
import com.yakindu.solidity.solidity.ReturnStatement;
import com.yakindu.solidity.solidity.SimpleArgument;
import com.yakindu.solidity.solidity.SimpleStatement;
import com.yakindu.solidity.solidity.SolidityFactory;
import com.yakindu.solidity.solidity.SolidityModel;
import com.yakindu.solidity.solidity.SolidityPackage;
import com.yakindu.solidity.solidity.SourceUnit;
import com.yakindu.solidity.solidity.Statement;
import com.yakindu.solidity.solidity.StorageLocation;
import com.yakindu.solidity.solidity.StructDefinition;
import com.yakindu.solidity.solidity.SuperTypeArgumentList;
import com.yakindu.solidity.solidity.ThrowStatement;
import com.yakindu.solidity.solidity.TupleExpression;
import com.yakindu.solidity.solidity.TypeDefinition;
import com.yakindu.solidity.solidity.TypeSpecifier;
import com.yakindu.solidity.solidity.UnaryOperator;
import com.yakindu.solidity.solidity.Unit;
import com.yakindu.solidity.solidity.UsingForDeclaration;
import com.yakindu.solidity.solidity.VariableDefinition;
import com.yakindu.solidity.solidity.Visibility;
import com.yakindu.solidity.solidity.WhileStatement;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.yakindu.base.base.BasePackage;

import org.yakindu.base.expressions.expressions.ExpressionsPackage;

import org.yakindu.base.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SolidityPackageImpl extends EPackageImpl implements SolidityPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass solidityModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pragmaDirectiveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass superTypeArgumentListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass buildInModifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modifierInvocationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass throwStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass placeholderStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass returnStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deleteStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass continueStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass breakStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inlineAssemblyStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identifierListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass whileStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inlineAssemblyBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assemblyLocalBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assemblyAssignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assemblyLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionalAssemblyExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass idLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass decimalNumberLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addressLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedArgumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleArgumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingTypeSpecifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arrayTypeSpecifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeSpecifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pragmaSolidityDirectiveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pragmaExperimentalDirectiveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass importDirectiveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contractDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass usingForDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modifierDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constructorDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass indexParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exponentialExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numericalUnaryExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass newInstanceExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass emitExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tupleExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveValueExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum contractTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum storageLocationEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum visibilityEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum unitEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum functionModifierEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum assemblyKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum unaryOperatorEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.yakindu.solidity.solidity.SolidityPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SolidityPackageImpl() {
		super(eNS_URI, SolidityFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link SolidityPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SolidityPackage init() {
		if (isInited) return (SolidityPackage)EPackage.Registry.INSTANCE.getEPackage(SolidityPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredSolidityPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		SolidityPackageImpl theSolidityPackage = registeredSolidityPackage instanceof SolidityPackageImpl ? (SolidityPackageImpl)registeredSolidityPackage : new SolidityPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		ExpressionsPackage.eINSTANCE.eClass();
		BasePackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSolidityPackage.createPackageContents();

		// Initialize created meta-data
		theSolidityPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSolidityPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SolidityPackage.eNS_URI, theSolidityPackage);
		return theSolidityPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSolidityModel() {
		return solidityModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSolidityModel_Sourceunit() {
		return (EReference)solidityModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPragmaDirective() {
		return pragmaDirectiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSuperTypeArgumentList() {
		return superTypeArgumentListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSuperTypeArgumentList_Arguments() {
		return (EReference)superTypeArgumentListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBlock() {
		return blockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBlock_Statements() {
		return (EReference)blockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getModifier() {
		return modifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBuildInModifier() {
		return buildInModifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBuildInModifier_Type() {
		return (EAttribute)buildInModifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getModifierInvocation() {
		return modifierInvocationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModifierInvocation_Reference() {
		return (EReference)modifierInvocationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModifierInvocation_Arguments() {
		return (EReference)modifierInvocationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStatement() {
		return statementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getThrowStatement() {
		return throwStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSimpleStatement() {
		return simpleStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPlaceholderStatement() {
		return placeholderStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getReturnStatement() {
		return returnStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getReturnStatement_Expression() {
		return (EReference)returnStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDeleteStatement() {
		return deleteStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDeleteStatement_Expression() {
		return (EReference)deleteStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getContinueStatement() {
		return continueStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBreakStatement() {
		return breakStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExpressionStatement() {
		return expressionStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExpressionStatement_Expression() {
		return (EReference)expressionStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInlineAssemblyStatement() {
		return inlineAssemblyStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInlineAssemblyStatement_Kind() {
		return (EAttribute)inlineAssemblyStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInlineAssemblyStatement_Block() {
		return (EReference)inlineAssemblyStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVariableDefinition() {
		return variableDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getVariableDefinition_Visibility() {
		return (EAttribute)variableDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVariableDefinition_InitialValue() {
		return (EReference)variableDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getVariableDefinition_Storage() {
		return (EAttribute)variableDefinitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVariableDefinition_Identifier() {
		return (EReference)variableDefinitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIdentifierList() {
		return identifierListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIdentifierList_Identifier() {
		return (EReference)identifierListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIfStatement() {
		return ifStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIfStatement_Condition() {
		return (EReference)ifStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIfStatement_Then() {
		return (EReference)ifStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIfStatement_Else() {
		return (EReference)ifStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getWhileStatement() {
		return whileStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getWhileStatement_Condition() {
		return (EReference)whileStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getWhileStatement_Body() {
		return (EReference)whileStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getForStatement() {
		return forStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getForStatement_Initialization() {
		return (EReference)forStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getForStatement_Condition() {
		return (EReference)forStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getForStatement_Afterthought() {
		return (EReference)forStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getForStatement_Statement() {
		return (EReference)forStatementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInlineAssemblyBlock() {
		return inlineAssemblyBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInlineAssemblyBlock_Items() {
		return (EReference)inlineAssemblyBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAssemblyLocalBinding() {
		return assemblyLocalBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAssemblyLocalBinding_Label() {
		return (EAttribute)assemblyLocalBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAssemblyLocalBinding_Expression() {
		return (EReference)assemblyLocalBindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAssemblyAssignment() {
		return assemblyAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAssemblyAssignment_LeftOperand() {
		return (EAttribute)assemblyAssignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAssemblyAssignment_Expression() {
		return (EReference)assemblyAssignmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAssemblyAssignment_RightOpernd() {
		return (EAttribute)assemblyAssignmentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAssemblyLabel() {
		return assemblyLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAssemblyLabel_Label() {
		return (EAttribute)assemblyLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFunctionalAssemblyExpression() {
		return functionalAssemblyExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFunctionalAssemblyExpression_Label() {
		return (EAttribute)functionalAssemblyExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFunctionalAssemblyExpression_Parameters() {
		return (EReference)functionalAssemblyExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIDLiteral() {
		return idLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIDLiteral_Value() {
		return (EAttribute)idLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDecimalNumberLiteral() {
		return decimalNumberLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDecimalNumberLiteral_Value() {
		return (EAttribute)decimalNumberLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDecimalNumberLiteral_Unit() {
		return (EAttribute)decimalNumberLiteralEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAddressLiteral() {
		return addressLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAddressLiteral_Value() {
		return (EAttribute)addressLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNamedArgument() {
		return namedArgumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNamedArgument_Reference() {
		return (EReference)namedArgumentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSimpleArgument() {
		return simpleArgumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMappingTypeSpecifier() {
		return mappingTypeSpecifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingTypeSpecifier_Key() {
		return (EReference)mappingTypeSpecifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingTypeSpecifier_Value() {
		return (EReference)mappingTypeSpecifierEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getArrayTypeSpecifier() {
		return arrayTypeSpecifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getArrayTypeSpecifier_Index() {
		return (EReference)arrayTypeSpecifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTypeSpecifier() {
		return typeSpecifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSourceUnit() {
		return sourceUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSourceUnit_Pragma() {
		return (EReference)sourceUnitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSourceUnit_Imports() {
		return (EReference)sourceUnitEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPragmaSolidityDirective() {
		return pragmaSolidityDirectiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPragmaSolidityDirective_Version() {
		return (EAttribute)pragmaSolidityDirectiveEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPragmaExperimentalDirective() {
		return pragmaExperimentalDirectiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPragmaExperimentalDirective_Value() {
		return (EAttribute)pragmaExperimentalDirectiveEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImportDirective() {
		return importDirectiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImportDirective_ImportedNamespace() {
		return (EAttribute)importDirectiveEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImportDirective_Alias() {
		return (EAttribute)importDirectiveEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getContractDefinition() {
		return contractDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getContractDefinition_Type() {
		return (EAttribute)contractDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getContractDefinition_ArgumentList() {
		return (EReference)contractDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUsingForDeclaration() {
		return usingForDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getUsingForDeclaration_Contract() {
		return (EReference)usingForDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTypeDefinition() {
		return typeDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTypeDefinition_Definition() {
		return (EReference)typeDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStructDefinition() {
		return structDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getModifierDefinition() {
		return modifierDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModifierDefinition_Block() {
		return (EReference)modifierDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConstructorDefinition() {
		return constructorDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConstructorDefinition_Modifier() {
		return (EReference)constructorDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConstructorDefinition_Block() {
		return (EReference)constructorDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEventDefinition() {
		return eventDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFunctionDefinition() {
		return functionDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFunctionDefinition_Modifier() {
		return (EReference)functionDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFunctionDefinition_ReturnParameters() {
		return (EReference)functionDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFunctionDefinition_Block() {
		return (EReference)functionDefinitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getParameter() {
		return parameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getParameter_Storage() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIndexParameter() {
		return indexParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIndexParameter_Indexed() {
		return (EAttribute)indexParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIdentifier() {
		return identifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExponentialExpression() {
		return exponentialExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExponentialExpression_LeftOperand() {
		return (EReference)exponentialExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExponentialExpression_RightOperand() {
		return (EReference)exponentialExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNumericalUnaryExpression() {
		return numericalUnaryExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNumericalUnaryExpression_Operator() {
		return (EAttribute)numericalUnaryExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNumericalUnaryExpression_Operand() {
		return (EReference)numericalUnaryExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNewInstanceExpression() {
		return newInstanceExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNewInstanceExpression_Type() {
		return (EReference)newInstanceExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEmitExpression() {
		return emitExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEmitExpression_Event() {
		return (EReference)emitExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTupleExpression() {
		return tupleExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTupleExpression_Expressions() {
		return (EReference)tupleExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPrimitiveValueExpression() {
		return primitiveValueExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getContractType() {
		return contractTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getStorageLocation() {
		return storageLocationEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getVisibility() {
		return visibilityEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getUnit() {
		return unitEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getFunctionModifier() {
		return functionModifierEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getAssemblyKind() {
		return assemblyKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getUnaryOperator() {
		return unaryOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SolidityFactory getSolidityFactory() {
		return (SolidityFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		solidityModelEClass = createEClass(SOLIDITY_MODEL);
		createEReference(solidityModelEClass, SOLIDITY_MODEL__SOURCEUNIT);

		pragmaDirectiveEClass = createEClass(PRAGMA_DIRECTIVE);

		superTypeArgumentListEClass = createEClass(SUPER_TYPE_ARGUMENT_LIST);
		createEReference(superTypeArgumentListEClass, SUPER_TYPE_ARGUMENT_LIST__ARGUMENTS);

		blockEClass = createEClass(BLOCK);
		createEReference(blockEClass, BLOCK__STATEMENTS);

		modifierEClass = createEClass(MODIFIER);

		buildInModifierEClass = createEClass(BUILD_IN_MODIFIER);
		createEAttribute(buildInModifierEClass, BUILD_IN_MODIFIER__TYPE);

		modifierInvocationEClass = createEClass(MODIFIER_INVOCATION);
		createEReference(modifierInvocationEClass, MODIFIER_INVOCATION__REFERENCE);
		createEReference(modifierInvocationEClass, MODIFIER_INVOCATION__ARGUMENTS);

		statementEClass = createEClass(STATEMENT);

		throwStatementEClass = createEClass(THROW_STATEMENT);

		simpleStatementEClass = createEClass(SIMPLE_STATEMENT);

		placeholderStatementEClass = createEClass(PLACEHOLDER_STATEMENT);

		returnStatementEClass = createEClass(RETURN_STATEMENT);
		createEReference(returnStatementEClass, RETURN_STATEMENT__EXPRESSION);

		deleteStatementEClass = createEClass(DELETE_STATEMENT);
		createEReference(deleteStatementEClass, DELETE_STATEMENT__EXPRESSION);

		continueStatementEClass = createEClass(CONTINUE_STATEMENT);

		breakStatementEClass = createEClass(BREAK_STATEMENT);

		expressionStatementEClass = createEClass(EXPRESSION_STATEMENT);
		createEReference(expressionStatementEClass, EXPRESSION_STATEMENT__EXPRESSION);

		inlineAssemblyStatementEClass = createEClass(INLINE_ASSEMBLY_STATEMENT);
		createEAttribute(inlineAssemblyStatementEClass, INLINE_ASSEMBLY_STATEMENT__KIND);
		createEReference(inlineAssemblyStatementEClass, INLINE_ASSEMBLY_STATEMENT__BLOCK);

		variableDefinitionEClass = createEClass(VARIABLE_DEFINITION);
		createEAttribute(variableDefinitionEClass, VARIABLE_DEFINITION__VISIBILITY);
		createEReference(variableDefinitionEClass, VARIABLE_DEFINITION__INITIAL_VALUE);
		createEAttribute(variableDefinitionEClass, VARIABLE_DEFINITION__STORAGE);
		createEReference(variableDefinitionEClass, VARIABLE_DEFINITION__IDENTIFIER);

		identifierListEClass = createEClass(IDENTIFIER_LIST);
		createEReference(identifierListEClass, IDENTIFIER_LIST__IDENTIFIER);

		ifStatementEClass = createEClass(IF_STATEMENT);
		createEReference(ifStatementEClass, IF_STATEMENT__CONDITION);
		createEReference(ifStatementEClass, IF_STATEMENT__THEN);
		createEReference(ifStatementEClass, IF_STATEMENT__ELSE);

		whileStatementEClass = createEClass(WHILE_STATEMENT);
		createEReference(whileStatementEClass, WHILE_STATEMENT__CONDITION);
		createEReference(whileStatementEClass, WHILE_STATEMENT__BODY);

		forStatementEClass = createEClass(FOR_STATEMENT);
		createEReference(forStatementEClass, FOR_STATEMENT__INITIALIZATION);
		createEReference(forStatementEClass, FOR_STATEMENT__CONDITION);
		createEReference(forStatementEClass, FOR_STATEMENT__AFTERTHOUGHT);
		createEReference(forStatementEClass, FOR_STATEMENT__STATEMENT);

		inlineAssemblyBlockEClass = createEClass(INLINE_ASSEMBLY_BLOCK);
		createEReference(inlineAssemblyBlockEClass, INLINE_ASSEMBLY_BLOCK__ITEMS);

		assemblyLocalBindingEClass = createEClass(ASSEMBLY_LOCAL_BINDING);
		createEAttribute(assemblyLocalBindingEClass, ASSEMBLY_LOCAL_BINDING__LABEL);
		createEReference(assemblyLocalBindingEClass, ASSEMBLY_LOCAL_BINDING__EXPRESSION);

		assemblyAssignmentEClass = createEClass(ASSEMBLY_ASSIGNMENT);
		createEAttribute(assemblyAssignmentEClass, ASSEMBLY_ASSIGNMENT__LEFT_OPERAND);
		createEReference(assemblyAssignmentEClass, ASSEMBLY_ASSIGNMENT__EXPRESSION);
		createEAttribute(assemblyAssignmentEClass, ASSEMBLY_ASSIGNMENT__RIGHT_OPERND);

		assemblyLabelEClass = createEClass(ASSEMBLY_LABEL);
		createEAttribute(assemblyLabelEClass, ASSEMBLY_LABEL__LABEL);

		functionalAssemblyExpressionEClass = createEClass(FUNCTIONAL_ASSEMBLY_EXPRESSION);
		createEAttribute(functionalAssemblyExpressionEClass, FUNCTIONAL_ASSEMBLY_EXPRESSION__LABEL);
		createEReference(functionalAssemblyExpressionEClass, FUNCTIONAL_ASSEMBLY_EXPRESSION__PARAMETERS);

		idLiteralEClass = createEClass(ID_LITERAL);
		createEAttribute(idLiteralEClass, ID_LITERAL__VALUE);

		decimalNumberLiteralEClass = createEClass(DECIMAL_NUMBER_LITERAL);
		createEAttribute(decimalNumberLiteralEClass, DECIMAL_NUMBER_LITERAL__VALUE);
		createEAttribute(decimalNumberLiteralEClass, DECIMAL_NUMBER_LITERAL__UNIT);

		addressLiteralEClass = createEClass(ADDRESS_LITERAL);
		createEAttribute(addressLiteralEClass, ADDRESS_LITERAL__VALUE);

		namedArgumentEClass = createEClass(NAMED_ARGUMENT);
		createEReference(namedArgumentEClass, NAMED_ARGUMENT__REFERENCE);

		simpleArgumentEClass = createEClass(SIMPLE_ARGUMENT);

		mappingTypeSpecifierEClass = createEClass(MAPPING_TYPE_SPECIFIER);
		createEReference(mappingTypeSpecifierEClass, MAPPING_TYPE_SPECIFIER__KEY);
		createEReference(mappingTypeSpecifierEClass, MAPPING_TYPE_SPECIFIER__VALUE);

		arrayTypeSpecifierEClass = createEClass(ARRAY_TYPE_SPECIFIER);
		createEReference(arrayTypeSpecifierEClass, ARRAY_TYPE_SPECIFIER__INDEX);

		typeSpecifierEClass = createEClass(TYPE_SPECIFIER);

		sourceUnitEClass = createEClass(SOURCE_UNIT);
		createEReference(sourceUnitEClass, SOURCE_UNIT__PRAGMA);
		createEReference(sourceUnitEClass, SOURCE_UNIT__IMPORTS);

		pragmaSolidityDirectiveEClass = createEClass(PRAGMA_SOLIDITY_DIRECTIVE);
		createEAttribute(pragmaSolidityDirectiveEClass, PRAGMA_SOLIDITY_DIRECTIVE__VERSION);

		pragmaExperimentalDirectiveEClass = createEClass(PRAGMA_EXPERIMENTAL_DIRECTIVE);
		createEAttribute(pragmaExperimentalDirectiveEClass, PRAGMA_EXPERIMENTAL_DIRECTIVE__VALUE);

		importDirectiveEClass = createEClass(IMPORT_DIRECTIVE);
		createEAttribute(importDirectiveEClass, IMPORT_DIRECTIVE__IMPORTED_NAMESPACE);
		createEAttribute(importDirectiveEClass, IMPORT_DIRECTIVE__ALIAS);

		contractDefinitionEClass = createEClass(CONTRACT_DEFINITION);
		createEAttribute(contractDefinitionEClass, CONTRACT_DEFINITION__TYPE);
		createEReference(contractDefinitionEClass, CONTRACT_DEFINITION__ARGUMENT_LIST);

		usingForDeclarationEClass = createEClass(USING_FOR_DECLARATION);
		createEReference(usingForDeclarationEClass, USING_FOR_DECLARATION__CONTRACT);

		typeDefinitionEClass = createEClass(TYPE_DEFINITION);
		createEReference(typeDefinitionEClass, TYPE_DEFINITION__DEFINITION);

		structDefinitionEClass = createEClass(STRUCT_DEFINITION);

		modifierDefinitionEClass = createEClass(MODIFIER_DEFINITION);
		createEReference(modifierDefinitionEClass, MODIFIER_DEFINITION__BLOCK);

		constructorDefinitionEClass = createEClass(CONSTRUCTOR_DEFINITION);
		createEReference(constructorDefinitionEClass, CONSTRUCTOR_DEFINITION__MODIFIER);
		createEReference(constructorDefinitionEClass, CONSTRUCTOR_DEFINITION__BLOCK);

		eventDefinitionEClass = createEClass(EVENT_DEFINITION);

		functionDefinitionEClass = createEClass(FUNCTION_DEFINITION);
		createEReference(functionDefinitionEClass, FUNCTION_DEFINITION__MODIFIER);
		createEReference(functionDefinitionEClass, FUNCTION_DEFINITION__RETURN_PARAMETERS);
		createEReference(functionDefinitionEClass, FUNCTION_DEFINITION__BLOCK);

		parameterEClass = createEClass(PARAMETER);
		createEAttribute(parameterEClass, PARAMETER__STORAGE);

		indexParameterEClass = createEClass(INDEX_PARAMETER);
		createEAttribute(indexParameterEClass, INDEX_PARAMETER__INDEXED);

		identifierEClass = createEClass(IDENTIFIER);

		exponentialExpressionEClass = createEClass(EXPONENTIAL_EXPRESSION);
		createEReference(exponentialExpressionEClass, EXPONENTIAL_EXPRESSION__LEFT_OPERAND);
		createEReference(exponentialExpressionEClass, EXPONENTIAL_EXPRESSION__RIGHT_OPERAND);

		numericalUnaryExpressionEClass = createEClass(NUMERICAL_UNARY_EXPRESSION);
		createEAttribute(numericalUnaryExpressionEClass, NUMERICAL_UNARY_EXPRESSION__OPERATOR);
		createEReference(numericalUnaryExpressionEClass, NUMERICAL_UNARY_EXPRESSION__OPERAND);

		newInstanceExpressionEClass = createEClass(NEW_INSTANCE_EXPRESSION);
		createEReference(newInstanceExpressionEClass, NEW_INSTANCE_EXPRESSION__TYPE);

		emitExpressionEClass = createEClass(EMIT_EXPRESSION);
		createEReference(emitExpressionEClass, EMIT_EXPRESSION__EVENT);

		tupleExpressionEClass = createEClass(TUPLE_EXPRESSION);
		createEReference(tupleExpressionEClass, TUPLE_EXPRESSION__EXPRESSIONS);

		primitiveValueExpressionEClass = createEClass(PRIMITIVE_VALUE_EXPRESSION);

		// Create enums
		contractTypeEEnum = createEEnum(CONTRACT_TYPE);
		storageLocationEEnum = createEEnum(STORAGE_LOCATION);
		visibilityEEnum = createEEnum(VISIBILITY);
		unitEEnum = createEEnum(UNIT);
		functionModifierEEnum = createEEnum(FUNCTION_MODIFIER);
		assemblyKindEEnum = createEEnum(ASSEMBLY_KIND);
		unaryOperatorEEnum = createEEnum(UNARY_OPERATOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		ExpressionsPackage theExpressionsPackage = (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		pragmaDirectiveEClass.getESuperTypes().add(theTypesPackage.getPackageMember());
		blockEClass.getESuperTypes().add(this.getStatement());
		buildInModifierEClass.getESuperTypes().add(this.getModifier());
		modifierInvocationEClass.getESuperTypes().add(this.getModifier());
		throwStatementEClass.getESuperTypes().add(this.getStatement());
		simpleStatementEClass.getESuperTypes().add(this.getStatement());
		placeholderStatementEClass.getESuperTypes().add(this.getStatement());
		returnStatementEClass.getESuperTypes().add(this.getStatement());
		deleteStatementEClass.getESuperTypes().add(this.getStatement());
		continueStatementEClass.getESuperTypes().add(this.getStatement());
		breakStatementEClass.getESuperTypes().add(this.getStatement());
		expressionStatementEClass.getESuperTypes().add(this.getSimpleStatement());
		inlineAssemblyStatementEClass.getESuperTypes().add(this.getStatement());
		variableDefinitionEClass.getESuperTypes().add(theTypesPackage.getProperty());
		variableDefinitionEClass.getESuperTypes().add(this.getSimpleStatement());
		ifStatementEClass.getESuperTypes().add(this.getStatement());
		whileStatementEClass.getESuperTypes().add(this.getStatement());
		forStatementEClass.getESuperTypes().add(this.getStatement());
		decimalNumberLiteralEClass.getESuperTypes().add(theExpressionsPackage.getLiteral());
		addressLiteralEClass.getESuperTypes().add(theExpressionsPackage.getLiteral());
		namedArgumentEClass.getESuperTypes().add(theExpressionsPackage.getArgument());
		simpleArgumentEClass.getESuperTypes().add(theExpressionsPackage.getArgument());
		mappingTypeSpecifierEClass.getESuperTypes().add(theTypesPackage.getTypeSpecifier());
		arrayTypeSpecifierEClass.getESuperTypes().add(theTypesPackage.getTypeSpecifier());
		typeSpecifierEClass.getESuperTypes().add(theTypesPackage.getTypeSpecifier());
		sourceUnitEClass.getESuperTypes().add(theTypesPackage.getPackage());
		pragmaSolidityDirectiveEClass.getESuperTypes().add(this.getPragmaDirective());
		pragmaExperimentalDirectiveEClass.getESuperTypes().add(this.getPragmaDirective());
		importDirectiveEClass.getESuperTypes().add(theTypesPackage.getPackageMember());
		contractDefinitionEClass.getESuperTypes().add(theTypesPackage.getComplexType());
		usingForDeclarationEClass.getESuperTypes().add(theTypesPackage.getDeclaration());
		typeDefinitionEClass.getESuperTypes().add(theTypesPackage.getDeclaration());
		structDefinitionEClass.getESuperTypes().add(theTypesPackage.getComplexType());
		modifierDefinitionEClass.getESuperTypes().add(theTypesPackage.getOperation());
		constructorDefinitionEClass.getESuperTypes().add(theTypesPackage.getOperation());
		eventDefinitionEClass.getESuperTypes().add(theTypesPackage.getOperation());
		functionDefinitionEClass.getESuperTypes().add(theTypesPackage.getOperation());
		parameterEClass.getESuperTypes().add(theTypesPackage.getParameter());
		indexParameterEClass.getESuperTypes().add(theTypesPackage.getParameter());
		identifierEClass.getESuperTypes().add(theTypesPackage.getDeclaration());
		exponentialExpressionEClass.getESuperTypes().add(theExpressionsPackage.getExpression());
		numericalUnaryExpressionEClass.getESuperTypes().add(theExpressionsPackage.getExpression());
		newInstanceExpressionEClass.getESuperTypes().add(theExpressionsPackage.getFeatureCall());
		emitExpressionEClass.getESuperTypes().add(theExpressionsPackage.getFeatureCall());
		tupleExpressionEClass.getESuperTypes().add(theExpressionsPackage.getExpression());
		primitiveValueExpressionEClass.getESuperTypes().add(theExpressionsPackage.getPrimitiveValueExpression());

		// Initialize classes and features; add operations and parameters
		initEClass(solidityModelEClass, SolidityModel.class, "SolidityModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSolidityModel_Sourceunit(), theTypesPackage.getPackage(), null, "sourceunit", null, 0, -1, SolidityModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pragmaDirectiveEClass, PragmaDirective.class, "PragmaDirective", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(superTypeArgumentListEClass, SuperTypeArgumentList.class, "SuperTypeArgumentList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSuperTypeArgumentList_Arguments(), theExpressionsPackage.getExpression(), null, "arguments", null, 0, -1, SuperTypeArgumentList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(blockEClass, Block.class, "Block", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBlock_Statements(), this.getStatement(), null, "statements", null, 0, -1, Block.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modifierEClass, Modifier.class, "Modifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(buildInModifierEClass, BuildInModifier.class, "BuildInModifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBuildInModifier_Type(), this.getFunctionModifier(), "type", null, 0, 1, BuildInModifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modifierInvocationEClass, ModifierInvocation.class, "ModifierInvocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModifierInvocation_Reference(), theTypesPackage.getOperation(), null, "reference", null, 0, 1, ModifierInvocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModifierInvocation_Arguments(), theExpressionsPackage.getArgument(), null, "arguments", null, 0, -1, ModifierInvocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(statementEClass, Statement.class, "Statement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(throwStatementEClass, ThrowStatement.class, "ThrowStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(simpleStatementEClass, SimpleStatement.class, "SimpleStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(placeholderStatementEClass, PlaceholderStatement.class, "PlaceholderStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(returnStatementEClass, ReturnStatement.class, "ReturnStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReturnStatement_Expression(), theExpressionsPackage.getExpression(), null, "expression", null, 0, 1, ReturnStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deleteStatementEClass, DeleteStatement.class, "DeleteStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeleteStatement_Expression(), theExpressionsPackage.getExpression(), null, "expression", null, 0, 1, DeleteStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(continueStatementEClass, ContinueStatement.class, "ContinueStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(breakStatementEClass, BreakStatement.class, "BreakStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(expressionStatementEClass, ExpressionStatement.class, "ExpressionStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpressionStatement_Expression(), theExpressionsPackage.getExpression(), null, "expression", null, 0, 1, ExpressionStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inlineAssemblyStatementEClass, InlineAssemblyStatement.class, "InlineAssemblyStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInlineAssemblyStatement_Kind(), this.getAssemblyKind(), "kind", null, 0, 1, InlineAssemblyStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInlineAssemblyStatement_Block(), this.getInlineAssemblyBlock(), null, "block", null, 0, 1, InlineAssemblyStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableDefinitionEClass, VariableDefinition.class, "VariableDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariableDefinition_Visibility(), this.getVisibility(), "visibility", null, 0, 1, VariableDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariableDefinition_InitialValue(), theExpressionsPackage.getExpression(), null, "initialValue", null, 0, 1, VariableDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVariableDefinition_Storage(), this.getStorageLocation(), "storage", null, 0, 1, VariableDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariableDefinition_Identifier(), this.getIdentifierList(), null, "identifier", null, 0, 1, VariableDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(identifierListEClass, IdentifierList.class, "IdentifierList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIdentifierList_Identifier(), theTypesPackage.getDeclaration(), null, "identifier", null, 0, -1, IdentifierList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ifStatementEClass, IfStatement.class, "IfStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIfStatement_Condition(), theExpressionsPackage.getExpression(), null, "condition", null, 0, 1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIfStatement_Then(), this.getStatement(), null, "then", null, 0, 1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIfStatement_Else(), this.getStatement(), null, "else", null, 0, 1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(whileStatementEClass, WhileStatement.class, "WhileStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWhileStatement_Condition(), theExpressionsPackage.getExpression(), null, "condition", null, 0, 1, WhileStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWhileStatement_Body(), this.getStatement(), null, "body", null, 0, 1, WhileStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(forStatementEClass, ForStatement.class, "ForStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getForStatement_Initialization(), this.getSimpleStatement(), null, "initialization", null, 0, 1, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForStatement_Condition(), theExpressionsPackage.getExpression(), null, "condition", null, 0, 1, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForStatement_Afterthought(), theExpressionsPackage.getExpression(), null, "afterthought", null, 0, 1, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForStatement_Statement(), this.getStatement(), null, "statement", null, 0, 1, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inlineAssemblyBlockEClass, InlineAssemblyBlock.class, "InlineAssemblyBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInlineAssemblyBlock_Items(), ecorePackage.getEObject(), null, "items", null, 0, -1, InlineAssemblyBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(assemblyLocalBindingEClass, AssemblyLocalBinding.class, "AssemblyLocalBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAssemblyLocalBinding_Label(), ecorePackage.getEString(), "label", null, 0, 1, AssemblyLocalBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssemblyLocalBinding_Expression(), ecorePackage.getEObject(), null, "expression", null, 0, 1, AssemblyLocalBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(assemblyAssignmentEClass, AssemblyAssignment.class, "AssemblyAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAssemblyAssignment_LeftOperand(), ecorePackage.getEString(), "leftOperand", null, 0, 1, AssemblyAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssemblyAssignment_Expression(), this.getFunctionalAssemblyExpression(), null, "expression", null, 0, 1, AssemblyAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssemblyAssignment_RightOpernd(), ecorePackage.getEString(), "rightOpernd", null, 0, 1, AssemblyAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(assemblyLabelEClass, AssemblyLabel.class, "AssemblyLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAssemblyLabel_Label(), ecorePackage.getEString(), "label", null, 0, 1, AssemblyLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionalAssemblyExpressionEClass, FunctionalAssemblyExpression.class, "FunctionalAssemblyExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFunctionalAssemblyExpression_Label(), ecorePackage.getEString(), "label", null, 0, 1, FunctionalAssemblyExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionalAssemblyExpression_Parameters(), ecorePackage.getEObject(), null, "parameters", null, 0, -1, FunctionalAssemblyExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(idLiteralEClass, IDLiteral.class, "IDLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIDLiteral_Value(), ecorePackage.getEString(), "value", null, 0, 1, IDLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(decimalNumberLiteralEClass, DecimalNumberLiteral.class, "DecimalNumberLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDecimalNumberLiteral_Value(), ecorePackage.getEBigDecimal(), "value", null, 0, 1, DecimalNumberLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDecimalNumberLiteral_Unit(), this.getUnit(), "unit", null, 0, 1, DecimalNumberLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(addressLiteralEClass, AddressLiteral.class, "AddressLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAddressLiteral_Value(), ecorePackage.getEBigInteger(), "value", null, 0, 1, AddressLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(namedArgumentEClass, NamedArgument.class, "NamedArgument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNamedArgument_Reference(), ecorePackage.getEObject(), null, "reference", null, 0, 1, NamedArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simpleArgumentEClass, SimpleArgument.class, "SimpleArgument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappingTypeSpecifierEClass, MappingTypeSpecifier.class, "MappingTypeSpecifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingTypeSpecifier_Key(), theTypesPackage.getTypeSpecifier(), null, "key", null, 0, 1, MappingTypeSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingTypeSpecifier_Value(), theTypesPackage.getTypeSpecifier(), null, "value", null, 0, 1, MappingTypeSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(arrayTypeSpecifierEClass, ArrayTypeSpecifier.class, "ArrayTypeSpecifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArrayTypeSpecifier_Index(), theExpressionsPackage.getPrimitiveValueExpression(), null, "index", null, 0, -1, ArrayTypeSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeSpecifierEClass, TypeSpecifier.class, "TypeSpecifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sourceUnitEClass, SourceUnit.class, "SourceUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSourceUnit_Pragma(), theTypesPackage.getPackageMember(), null, "pragma", null, 0, -1, SourceUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSourceUnit_Imports(), theTypesPackage.getPackageMember(), null, "imports", null, 0, -1, SourceUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pragmaSolidityDirectiveEClass, PragmaSolidityDirective.class, "PragmaSolidityDirective", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPragmaSolidityDirective_Version(), ecorePackage.getEString(), "version", null, 0, 1, PragmaSolidityDirective.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pragmaExperimentalDirectiveEClass, PragmaExperimentalDirective.class, "PragmaExperimentalDirective", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPragmaExperimentalDirective_Value(), ecorePackage.getEString(), "value", null, 0, 1, PragmaExperimentalDirective.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(importDirectiveEClass, ImportDirective.class, "ImportDirective", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImportDirective_ImportedNamespace(), ecorePackage.getEString(), "importedNamespace", null, 0, 1, ImportDirective.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImportDirective_Alias(), ecorePackage.getEString(), "alias", null, 0, 1, ImportDirective.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(contractDefinitionEClass, ContractDefinition.class, "ContractDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getContractDefinition_Type(), this.getContractType(), "type", null, 0, 1, ContractDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContractDefinition_ArgumentList(), this.getSuperTypeArgumentList(), null, "argumentList", null, 0, -1, ContractDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(usingForDeclarationEClass, UsingForDeclaration.class, "UsingForDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUsingForDeclaration_Contract(), this.getContractDefinition(), null, "contract", null, 0, 1, UsingForDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeDefinitionEClass, TypeDefinition.class, "TypeDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypeDefinition_Definition(), theTypesPackage.getType(), null, "definition", null, 0, 1, TypeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(structDefinitionEClass, StructDefinition.class, "StructDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(modifierDefinitionEClass, ModifierDefinition.class, "ModifierDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModifierDefinition_Block(), this.getBlock(), null, "block", null, 0, 1, ModifierDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constructorDefinitionEClass, ConstructorDefinition.class, "ConstructorDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstructorDefinition_Modifier(), this.getModifier(), null, "modifier", null, 0, -1, ConstructorDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstructorDefinition_Block(), this.getBlock(), null, "block", null, 0, 1, ConstructorDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eventDefinitionEClass, EventDefinition.class, "EventDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(functionDefinitionEClass, FunctionDefinition.class, "FunctionDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunctionDefinition_Modifier(), this.getModifier(), null, "modifier", null, 0, -1, FunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionDefinition_ReturnParameters(), theTypesPackage.getParameter(), null, "returnParameters", null, 0, -1, FunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionDefinition_Block(), this.getBlock(), null, "block", null, 0, 1, FunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParameter_Storage(), this.getStorageLocation(), "storage", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(indexParameterEClass, IndexParameter.class, "IndexParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIndexParameter_Indexed(), ecorePackage.getEBoolean(), "indexed", null, 0, 1, IndexParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(identifierEClass, Identifier.class, "Identifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(exponentialExpressionEClass, ExponentialExpression.class, "ExponentialExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExponentialExpression_LeftOperand(), theExpressionsPackage.getExpression(), null, "leftOperand", null, 0, 1, ExponentialExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExponentialExpression_RightOperand(), theExpressionsPackage.getExpression(), null, "rightOperand", null, 0, 1, ExponentialExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(numericalUnaryExpressionEClass, NumericalUnaryExpression.class, "NumericalUnaryExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNumericalUnaryExpression_Operator(), this.getUnaryOperator(), "operator", null, 0, 1, NumericalUnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNumericalUnaryExpression_Operand(), theExpressionsPackage.getExpression(), null, "operand", null, 0, 1, NumericalUnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(newInstanceExpressionEClass, NewInstanceExpression.class, "NewInstanceExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNewInstanceExpression_Type(), theTypesPackage.getTypeSpecifier(), null, "type", null, 0, 1, NewInstanceExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(emitExpressionEClass, EmitExpression.class, "EmitExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEmitExpression_Event(), this.getEventDefinition(), null, "event", null, 0, 1, EmitExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tupleExpressionEClass, TupleExpression.class, "TupleExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTupleExpression_Expressions(), ecorePackage.getEObject(), null, "expressions", null, 0, -1, TupleExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primitiveValueExpressionEClass, PrimitiveValueExpression.class, "PrimitiveValueExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(contractTypeEEnum, ContractType.class, "ContractType");
		addEEnumLiteral(contractTypeEEnum, ContractType.CONTRACT);
		addEEnumLiteral(contractTypeEEnum, ContractType.LIBRARY);
		addEEnumLiteral(contractTypeEEnum, ContractType.INTERFACE);

		initEEnum(storageLocationEEnum, StorageLocation.class, "StorageLocation");
		addEEnumLiteral(storageLocationEEnum, StorageLocation.MEMORY);
		addEEnumLiteral(storageLocationEEnum, StorageLocation.STORAGE);
		addEEnumLiteral(storageLocationEEnum, StorageLocation.CALLDATA);

		initEEnum(visibilityEEnum, Visibility.class, "Visibility");
		addEEnumLiteral(visibilityEEnum, Visibility.PUBLIC);
		addEEnumLiteral(visibilityEEnum, Visibility.INTERNAL);
		addEEnumLiteral(visibilityEEnum, Visibility.PRIVATE);

		initEEnum(unitEEnum, Unit.class, "Unit");
		addEEnumLiteral(unitEEnum, Unit.SECONDS);
		addEEnumLiteral(unitEEnum, Unit.MINUTES);
		addEEnumLiteral(unitEEnum, Unit.HOURS);
		addEEnumLiteral(unitEEnum, Unit.DAYS);
		addEEnumLiteral(unitEEnum, Unit.WEEKS);
		addEEnumLiteral(unitEEnum, Unit.YEARS);
		addEEnumLiteral(unitEEnum, Unit.WEI);
		addEEnumLiteral(unitEEnum, Unit.FINNEY);
		addEEnumLiteral(unitEEnum, Unit.SZABO);
		addEEnumLiteral(unitEEnum, Unit.ETHER);

		initEEnum(functionModifierEEnum, FunctionModifier.class, "FunctionModifier");
		addEEnumLiteral(functionModifierEEnum, FunctionModifier.EXTERNAL);
		addEEnumLiteral(functionModifierEEnum, FunctionModifier.PUBLIC);
		addEEnumLiteral(functionModifierEEnum, FunctionModifier.INTERNAL);
		addEEnumLiteral(functionModifierEEnum, FunctionModifier.PRIVATE);
		addEEnumLiteral(functionModifierEEnum, FunctionModifier.PURE);
		addEEnumLiteral(functionModifierEEnum, FunctionModifier.CONSTANT);
		addEEnumLiteral(functionModifierEEnum, FunctionModifier.VIEW);
		addEEnumLiteral(functionModifierEEnum, FunctionModifier.PAYABLE);

		initEEnum(assemblyKindEEnum, AssemblyKind.class, "AssemblyKind");
		addEEnumLiteral(assemblyKindEEnum, AssemblyKind.EVMASM);

		initEEnum(unaryOperatorEEnum, UnaryOperator.class, "UnaryOperator");
		addEEnumLiteral(unaryOperatorEEnum, UnaryOperator.INCREMENT);
		addEEnumLiteral(unaryOperatorEEnum, UnaryOperator.DECREMENT);
		addEEnumLiteral(unaryOperatorEEnum, UnaryOperator.POSITIVE);
		addEEnumLiteral(unaryOperatorEEnum, UnaryOperator.NEGATIVE);
		addEEnumLiteral(unaryOperatorEEnum, UnaryOperator.COMPLEMENT);

		// Create resource
		createResource(eNS_URI);
	}

} //SolidityPackageImpl
