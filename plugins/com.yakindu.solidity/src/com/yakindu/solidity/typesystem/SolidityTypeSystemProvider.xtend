package com.yakindu.solidity.typesystem

import com.google.inject.Inject
import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.yakindu.base.types.typesystem.ITypeSystem

class SolidityTypeSystemProvider implements IPragmaAwareProvider<AbstractSolidityTypeSystem> {

	@Inject
	Map<MajorSolidityVersion, AbstractSolidityTypeSystem> typeSystems;

	override provideFor(EObject element) {
		typeSystems.get(MajorSolidityVersion.versionFor(calculatePragma(element)))
	}

	override provideFor(Resource resource) {
		typeSystems.get(MajorSolidityVersion.versionFor(calculatePragma(resource)))
	}

}
