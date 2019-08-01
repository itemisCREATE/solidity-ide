package com.yakindu.solidity.ide.internal

import com.google.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.lsp4j.CodeAction
import org.eclipse.lsp4j.TextEdit
import org.eclipse.lsp4j.WorkspaceEdit
import org.eclipse.lsp4j.jsonrpc.messages.Either
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService2

class SolidityIdeCodeActionService implements ICodeActionService2 {

	@Inject extension CodeActionProvider

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

}
