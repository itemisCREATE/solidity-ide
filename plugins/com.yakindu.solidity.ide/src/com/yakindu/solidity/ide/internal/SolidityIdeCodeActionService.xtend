package com.yakindu.solidity.ide.internal

import com.google.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.lsp4j.CodeAction
import org.eclipse.lsp4j.TextEdit
import org.eclipse.lsp4j.WorkspaceEdit
import org.eclipse.lsp4j.jsonrpc.messages.Either
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService2
import com.yakindu.solidity.SolidityVersion
import com.google.inject.name.Named


import static com.yakindu.solidity.validation.IssueCodes.*


/**
 * @author Jonathan Thoene - Initial contribution and API
 */
class SolidityIdeCodeActionService implements ICodeActionService2 {

	@Inject @Named(SolidityVersion.SOLIDITY_VERSION) String solcVersion

	protected def addTextEdit(WorkspaceEdit edit, URI uri, TextEdit... textEdit) {
		edit.changes.put(uri.toString, textEdit)
	}
	
	override getCodeActions(Options options) {
		val resource = options.resource
		val params = options.codeActionParams
		val actions = newArrayList
		for (d : params.context.diagnostics) {
			if (d.code.hasSolution) {
				actions += Either.forRight(new CodeAction => [
					title = d.code.label
					diagnostics = #[d]
					edit = new WorkspaceEdit() => [
						addTextEdit(resource.URI, new TextEdit => [
							range = d.range
							newText = d.code.fix
						])
					]
				])
			}
		}
		return actions
	}
	
	
	def String getLabel(String issueCode) {
		switch (issueCode) {
			case WARNING_SOLIDITY_VERSION_NOT_THE_DEFAULT : '''Change version to «solcVersion»'''
			default: ""
		}
	}
	
	def String getFix(String issueCode) {
		switch (issueCode) {
			case WARNING_SOLIDITY_VERSION_NOT_THE_DEFAULT : solcVersion
			default: ""
		}
	}
	
	def boolean hasSolution(String issueCode) {
		return !issueCode.label.nullOrEmpty
	}

}
