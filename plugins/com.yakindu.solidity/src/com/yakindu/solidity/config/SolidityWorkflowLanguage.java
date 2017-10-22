package com.yakindu.solidity.config;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.xtext.generator.StandardLanguage;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.validation.ValidatorNaming;

import com.google.inject.Binder;
import com.google.inject.Inject;
import com.google.inject.Module;
import com.google.inject.util.Modules;

/**
 * As our validator is inheriting from the Expression language validator which has 'Java' in its name 
 * (ExpressionsJavaValidator instead of ExpressionsValidator) we need to adjust the computation of validator 
 * names as otherwise generation would create non-compiling code.
 * 
 */
@SuppressWarnings("restriction")
public class SolidityWorkflowLanguage extends StandardLanguage {

	@Override
	public Module getGuiceModule() {
		return Modules.override(super.getGuiceModule()).with(new Module() {

			@Override
			public void configure(Binder binder) {
				binder.bind(ValidatorNaming.class).to(OldValidatorNaming.class);
			}
			
		});
	}
	
	private static class OldValidatorNaming extends ValidatorNaming {
		
		@Inject
		private XtextGeneratorNaming naming;
		
		@Override
		public TypeReference getValidatorClass(Grammar grammar) {
			String runtimeBasePackage = naming.getRuntimeBasePackage(grammar) + ".validation.";
			String simpleName = GrammarUtil.getSimpleName(grammar);
			String name = runtimeBasePackage + simpleName + "JavaValidator";
			return new TypeReference(name);
		}
	}
	
}
