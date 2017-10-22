package com.yakindu.sct.domain.solidity.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.yakindu.base.types.TypeSpecifier;
import org.yakindu.base.types.TypesFactory;
import org.yakindu.base.types.typesystem.AbstractTypeSystem;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.model.stext.scoping.STextScopeProvider;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class SolidityScopeProvider extends STextScopeProvider {

	@Inject
	ITypeSystem typeSystem;

	@Override
	public IScope scope_ElementReferenceExpression_reference(EObject context, EReference reference) {
		IScope result = super.scope_ElementReferenceExpression_reference(context, reference);
		result = createImplicitVariables(result);
		return result;
	}

	protected IScope createImplicitVariables(IScope outer) {
		return Scopes.scopeFor(Lists.newArrayList(createMsg(), createBlock()), outer);
	}

	private VariableDefinition createMsg() {
		VariableDefinition msg = StextFactory.eINSTANCE.createVariableDefinition();
		TypeSpecifier specifier = TypesFactory.eINSTANCE.createTypeSpecifier();
		specifier.setType(typeSystem.getType("message"));
		msg.setTypeSpecifier(specifier);
		msg.setName("msg");
		msg.setConst(true);
		msg.setReadonly(true);
		((AbstractTypeSystem)typeSystem).getResource().getContents().add(msg);
		return msg;
	}
	
	private VariableDefinition createBlock() {
		VariableDefinition block = StextFactory.eINSTANCE.createVariableDefinition();
		TypeSpecifier specifier = TypesFactory.eINSTANCE.createTypeSpecifier();
		specifier.setType(typeSystem.getType("Block"));
		block.setTypeSpecifier(specifier);
		block.setName("block");
		block.setConst(true);
		block.setReadonly(true);
		((AbstractTypeSystem)typeSystem).getResource().getContents().add(block);
		return block;
	}
}
