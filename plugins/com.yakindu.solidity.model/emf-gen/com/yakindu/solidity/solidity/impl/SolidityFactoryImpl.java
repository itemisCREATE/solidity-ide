/**
 * (c) committers of YAKINDU
 */
package com.yakindu.solidity.solidity.impl;

import com.yakindu.solidity.solidity.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SolidityFactoryImpl extends EFactoryImpl implements SolidityFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SolidityFactory init() {
		try {
			SolidityFactory theSolidityFactory = (SolidityFactory)EPackage.Registry.INSTANCE.getEFactory(SolidityPackage.eNS_URI);
			if (theSolidityFactory != null) {
				return theSolidityFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SolidityFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SolidityFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SolidityPackage.SOLIDITY_MODEL: return createSolidityModel();
			case SolidityPackage.PRAGMA_DIRECTIVE: return createPragmaDirective();
			case SolidityPackage.SUPER_TYPE_ARGUMENT_LIST: return createSuperTypeArgumentList();
			case SolidityPackage.BLOCK: return createBlock();
			case SolidityPackage.MODIFIER: return createModifier();
			case SolidityPackage.BUILD_IN_MODIFIER: return createBuildInModifier();
			case SolidityPackage.MODIFIER_INVOCATION: return createModifierInvocation();
			case SolidityPackage.STATEMENT: return createStatement();
			case SolidityPackage.THROW_STATEMENT: return createThrowStatement();
			case SolidityPackage.SIMPLE_STATEMENT: return createSimpleStatement();
			case SolidityPackage.PLACEHOLDER_STATEMENT: return createPlaceholderStatement();
			case SolidityPackage.RETURN_STATEMENT: return createReturnStatement();
			case SolidityPackage.DELETE_STATEMENT: return createDeleteStatement();
			case SolidityPackage.CONTINUE_STATEMENT: return createContinueStatement();
			case SolidityPackage.BREAK_STATEMENT: return createBreakStatement();
			case SolidityPackage.EXPRESSION_STATEMENT: return createExpressionStatement();
			case SolidityPackage.INLINE_ASSEMBLY_STATEMENT: return createInlineAssemblyStatement();
			case SolidityPackage.VARIABLE_DEFINITION: return createVariableDefinition();
			case SolidityPackage.IDENTIFIER_LIST: return createIdentifierList();
			case SolidityPackage.IF_STATEMENT: return createIfStatement();
			case SolidityPackage.WHILE_STATEMENT: return createWhileStatement();
			case SolidityPackage.FOR_STATEMENT: return createForStatement();
			case SolidityPackage.INLINE_ASSEMBLY_BLOCK: return createInlineAssemblyBlock();
			case SolidityPackage.ASSEMBLY_LOCAL_BINDING: return createAssemblyLocalBinding();
			case SolidityPackage.ASSEMBLY_ASSIGNMENT: return createAssemblyAssignment();
			case SolidityPackage.ASSEMBLY_LABEL: return createAssemblyLabel();
			case SolidityPackage.FUNCTIONAL_ASSEMBLY_EXPRESSION: return createFunctionalAssemblyExpression();
			case SolidityPackage.ID_LITERAL: return createIDLiteral();
			case SolidityPackage.DECIMAL_NUMBER_LITERAL: return createDecimalNumberLiteral();
			case SolidityPackage.ADDRESS_LITERAL: return createAddressLiteral();
			case SolidityPackage.NAMED_ARGUMENT: return createNamedArgument();
			case SolidityPackage.SIMPLE_ARGUMENT: return createSimpleArgument();
			case SolidityPackage.MAPPING_TYPE_SPECIFIER: return createMappingTypeSpecifier();
			case SolidityPackage.ARRAY_TYPE_SPECIFIER: return createArrayTypeSpecifier();
			case SolidityPackage.TYPE_SPECIFIER: return createTypeSpecifier();
			case SolidityPackage.SOURCE_UNIT: return createSourceUnit();
			case SolidityPackage.PRAGMA_SOLIDITY_DIRECTIVE: return createPragmaSolidityDirective();
			case SolidityPackage.PRAGMA_EXPERIMENTAL_DIRECTIVE: return createPragmaExperimentalDirective();
			case SolidityPackage.IMPORT_DIRECTIVE: return createImportDirective();
			case SolidityPackage.CONTRACT_DEFINITION: return createContractDefinition();
			case SolidityPackage.USING_FOR_DECLARATION: return createUsingForDeclaration();
			case SolidityPackage.TYPE_DEFINITION: return createTypeDefinition();
			case SolidityPackage.STRUCT_DEFINITION: return createStructDefinition();
			case SolidityPackage.MODIFIER_DEFINITION: return createModifierDefinition();
			case SolidityPackage.CONSTRUCTOR_DEFINITION: return createConstructorDefinition();
			case SolidityPackage.EVENT_DEFINITION: return createEventDefinition();
			case SolidityPackage.FUNCTION_DEFINITION: return createFunctionDefinition();
			case SolidityPackage.PARAMETER: return createParameter();
			case SolidityPackage.INDEX_PARAMETER: return createIndexParameter();
			case SolidityPackage.IDENTIFIER: return createIdentifier();
			case SolidityPackage.EXPONENTIAL_EXPRESSION: return createExponentialExpression();
			case SolidityPackage.NUMERICAL_UNARY_EXPRESSION: return createNumericalUnaryExpression();
			case SolidityPackage.NEW_INSTANCE_EXPRESSION: return createNewInstanceExpression();
			case SolidityPackage.EMIT_EXPRESSION: return createEmitExpression();
			case SolidityPackage.TUPLE_EXPRESSION: return createTupleExpression();
			case SolidityPackage.PRIMITIVE_VALUE_EXPRESSION: return createPrimitiveValueExpression();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case SolidityPackage.CONTRACT_TYPE:
				return createContractTypeFromString(eDataType, initialValue);
			case SolidityPackage.STORAGE_LOCATION:
				return createStorageLocationFromString(eDataType, initialValue);
			case SolidityPackage.VISIBILITY:
				return createVisibilityFromString(eDataType, initialValue);
			case SolidityPackage.UNIT:
				return createUnitFromString(eDataType, initialValue);
			case SolidityPackage.FUNCTION_MODIFIER:
				return createFunctionModifierFromString(eDataType, initialValue);
			case SolidityPackage.ASSEMBLY_KIND:
				return createAssemblyKindFromString(eDataType, initialValue);
			case SolidityPackage.UNARY_OPERATOR:
				return createUnaryOperatorFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case SolidityPackage.CONTRACT_TYPE:
				return convertContractTypeToString(eDataType, instanceValue);
			case SolidityPackage.STORAGE_LOCATION:
				return convertStorageLocationToString(eDataType, instanceValue);
			case SolidityPackage.VISIBILITY:
				return convertVisibilityToString(eDataType, instanceValue);
			case SolidityPackage.UNIT:
				return convertUnitToString(eDataType, instanceValue);
			case SolidityPackage.FUNCTION_MODIFIER:
				return convertFunctionModifierToString(eDataType, instanceValue);
			case SolidityPackage.ASSEMBLY_KIND:
				return convertAssemblyKindToString(eDataType, instanceValue);
			case SolidityPackage.UNARY_OPERATOR:
				return convertUnaryOperatorToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SolidityModel createSolidityModel() {
		SolidityModelImpl solidityModel = new SolidityModelImpl();
		return solidityModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PragmaDirective createPragmaDirective() {
		PragmaDirectiveImpl pragmaDirective = new PragmaDirectiveImpl();
		return pragmaDirective;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SuperTypeArgumentList createSuperTypeArgumentList() {
		SuperTypeArgumentListImpl superTypeArgumentList = new SuperTypeArgumentListImpl();
		return superTypeArgumentList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Block createBlock() {
		BlockImpl block = new BlockImpl();
		return block;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Modifier createModifier() {
		ModifierImpl modifier = new ModifierImpl();
		return modifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BuildInModifier createBuildInModifier() {
		BuildInModifierImpl buildInModifier = new BuildInModifierImpl();
		return buildInModifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ModifierInvocation createModifierInvocation() {
		ModifierInvocationImpl modifierInvocation = new ModifierInvocationImpl();
		return modifierInvocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Statement createStatement() {
		StatementImpl statement = new StatementImpl();
		return statement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ThrowStatement createThrowStatement() {
		ThrowStatementImpl throwStatement = new ThrowStatementImpl();
		return throwStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SimpleStatement createSimpleStatement() {
		SimpleStatementImpl simpleStatement = new SimpleStatementImpl();
		return simpleStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PlaceholderStatement createPlaceholderStatement() {
		PlaceholderStatementImpl placeholderStatement = new PlaceholderStatementImpl();
		return placeholderStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ReturnStatement createReturnStatement() {
		ReturnStatementImpl returnStatement = new ReturnStatementImpl();
		return returnStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DeleteStatement createDeleteStatement() {
		DeleteStatementImpl deleteStatement = new DeleteStatementImpl();
		return deleteStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ContinueStatement createContinueStatement() {
		ContinueStatementImpl continueStatement = new ContinueStatementImpl();
		return continueStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BreakStatement createBreakStatement() {
		BreakStatementImpl breakStatement = new BreakStatementImpl();
		return breakStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExpressionStatement createExpressionStatement() {
		ExpressionStatementImpl expressionStatement = new ExpressionStatementImpl();
		return expressionStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InlineAssemblyStatement createInlineAssemblyStatement() {
		InlineAssemblyStatementImpl inlineAssemblyStatement = new InlineAssemblyStatementImpl();
		return inlineAssemblyStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VariableDefinition createVariableDefinition() {
		VariableDefinitionImpl variableDefinition = new VariableDefinitionImpl();
		return variableDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IdentifierList createIdentifierList() {
		IdentifierListImpl identifierList = new IdentifierListImpl();
		return identifierList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfStatement createIfStatement() {
		IfStatementImpl ifStatement = new IfStatementImpl();
		return ifStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public WhileStatement createWhileStatement() {
		WhileStatementImpl whileStatement = new WhileStatementImpl();
		return whileStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ForStatement createForStatement() {
		ForStatementImpl forStatement = new ForStatementImpl();
		return forStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InlineAssemblyBlock createInlineAssemblyBlock() {
		InlineAssemblyBlockImpl inlineAssemblyBlock = new InlineAssemblyBlockImpl();
		return inlineAssemblyBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AssemblyLocalBinding createAssemblyLocalBinding() {
		AssemblyLocalBindingImpl assemblyLocalBinding = new AssemblyLocalBindingImpl();
		return assemblyLocalBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AssemblyAssignment createAssemblyAssignment() {
		AssemblyAssignmentImpl assemblyAssignment = new AssemblyAssignmentImpl();
		return assemblyAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AssemblyLabel createAssemblyLabel() {
		AssemblyLabelImpl assemblyLabel = new AssemblyLabelImpl();
		return assemblyLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FunctionalAssemblyExpression createFunctionalAssemblyExpression() {
		FunctionalAssemblyExpressionImpl functionalAssemblyExpression = new FunctionalAssemblyExpressionImpl();
		return functionalAssemblyExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IDLiteral createIDLiteral() {
		IDLiteralImpl idLiteral = new IDLiteralImpl();
		return idLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DecimalNumberLiteral createDecimalNumberLiteral() {
		DecimalNumberLiteralImpl decimalNumberLiteral = new DecimalNumberLiteralImpl();
		return decimalNumberLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AddressLiteral createAddressLiteral() {
		AddressLiteralImpl addressLiteral = new AddressLiteralImpl();
		return addressLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NamedArgument createNamedArgument() {
		NamedArgumentImpl namedArgument = new NamedArgumentImpl();
		return namedArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SimpleArgument createSimpleArgument() {
		SimpleArgumentImpl simpleArgument = new SimpleArgumentImpl();
		return simpleArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MappingTypeSpecifier createMappingTypeSpecifier() {
		MappingTypeSpecifierImpl mappingTypeSpecifier = new MappingTypeSpecifierImpl();
		return mappingTypeSpecifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ArrayTypeSpecifier createArrayTypeSpecifier() {
		ArrayTypeSpecifierImpl arrayTypeSpecifier = new ArrayTypeSpecifierImpl();
		return arrayTypeSpecifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypeSpecifier createTypeSpecifier() {
		TypeSpecifierImpl typeSpecifier = new TypeSpecifierImpl();
		return typeSpecifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SourceUnit createSourceUnit() {
		SourceUnitImpl sourceUnit = new SourceUnitImpl();
		return sourceUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PragmaSolidityDirective createPragmaSolidityDirective() {
		PragmaSolidityDirectiveImpl pragmaSolidityDirective = new PragmaSolidityDirectiveImpl();
		return pragmaSolidityDirective;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PragmaExperimentalDirective createPragmaExperimentalDirective() {
		PragmaExperimentalDirectiveImpl pragmaExperimentalDirective = new PragmaExperimentalDirectiveImpl();
		return pragmaExperimentalDirective;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImportDirective createImportDirective() {
		ImportDirectiveImpl importDirective = new ImportDirectiveImpl();
		return importDirective;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ContractDefinition createContractDefinition() {
		ContractDefinitionImpl contractDefinition = new ContractDefinitionImpl();
		return contractDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UsingForDeclaration createUsingForDeclaration() {
		UsingForDeclarationImpl usingForDeclaration = new UsingForDeclarationImpl();
		return usingForDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypeDefinition createTypeDefinition() {
		TypeDefinitionImpl typeDefinition = new TypeDefinitionImpl();
		return typeDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StructDefinition createStructDefinition() {
		StructDefinitionImpl structDefinition = new StructDefinitionImpl();
		return structDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ModifierDefinition createModifierDefinition() {
		ModifierDefinitionImpl modifierDefinition = new ModifierDefinitionImpl();
		return modifierDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConstructorDefinition createConstructorDefinition() {
		ConstructorDefinitionImpl constructorDefinition = new ConstructorDefinitionImpl();
		return constructorDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EventDefinition createEventDefinition() {
		EventDefinitionImpl eventDefinition = new EventDefinitionImpl();
		return eventDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FunctionDefinition createFunctionDefinition() {
		FunctionDefinitionImpl functionDefinition = new FunctionDefinitionImpl();
		return functionDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Parameter createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IndexParameter createIndexParameter() {
		IndexParameterImpl indexParameter = new IndexParameterImpl();
		return indexParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Identifier createIdentifier() {
		IdentifierImpl identifier = new IdentifierImpl();
		return identifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExponentialExpression createExponentialExpression() {
		ExponentialExpressionImpl exponentialExpression = new ExponentialExpressionImpl();
		return exponentialExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NumericalUnaryExpression createNumericalUnaryExpression() {
		NumericalUnaryExpressionImpl numericalUnaryExpression = new NumericalUnaryExpressionImpl();
		return numericalUnaryExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NewInstanceExpression createNewInstanceExpression() {
		NewInstanceExpressionImpl newInstanceExpression = new NewInstanceExpressionImpl();
		return newInstanceExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EmitExpression createEmitExpression() {
		EmitExpressionImpl emitExpression = new EmitExpressionImpl();
		return emitExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TupleExpression createTupleExpression() {
		TupleExpressionImpl tupleExpression = new TupleExpressionImpl();
		return tupleExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PrimitiveValueExpression createPrimitiveValueExpression() {
		PrimitiveValueExpressionImpl primitiveValueExpression = new PrimitiveValueExpressionImpl();
		return primitiveValueExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContractType createContractTypeFromString(EDataType eDataType, String initialValue) {
		ContractType result = ContractType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertContractTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StorageLocation createStorageLocationFromString(EDataType eDataType, String initialValue) {
		StorageLocation result = StorageLocation.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStorageLocationToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Visibility createVisibilityFromString(EDataType eDataType, String initialValue) {
		Visibility result = Visibility.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVisibilityToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Unit createUnitFromString(EDataType eDataType, String initialValue) {
		Unit result = Unit.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUnitToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionModifier createFunctionModifierFromString(EDataType eDataType, String initialValue) {
		FunctionModifier result = FunctionModifier.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFunctionModifierToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyKind createAssemblyKindFromString(EDataType eDataType, String initialValue) {
		AssemblyKind result = AssemblyKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAssemblyKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnaryOperator createUnaryOperatorFromString(EDataType eDataType, String initialValue) {
		UnaryOperator result = UnaryOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUnaryOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SolidityPackage getSolidityPackage() {
		return (SolidityPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SolidityPackage getPackage() {
		return SolidityPackage.eINSTANCE;
	}

} //SolidityFactoryImpl
