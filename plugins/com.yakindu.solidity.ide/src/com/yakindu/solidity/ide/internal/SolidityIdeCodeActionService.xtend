package com.yakindu.solidity.ide.internal

import com.google.inject.Inject
import com.google.inject.name.Named
import com.yakindu.solidity.SolidityVersion
import com.yakindu.solidity.validation.IssueCodes
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.lsp4j.CodeAction
import org.eclipse.lsp4j.CodeActionParams
import org.eclipse.lsp4j.Command
import org.eclipse.lsp4j.TextEdit
import org.eclipse.lsp4j.WorkspaceEdit
import org.eclipse.lsp4j.jsonrpc.messages.Either
import org.eclipse.xtext.ide.server.Document
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.CancelIndicator

class SolidityIdeCodeActionService implements ICodeActionService {

	@Inject @Named(SolidityVersion.SOLIDITY_VERSION) String solcVersion

	override List<Either<Command, CodeAction>> getCodeActions(Document document, XtextResource resource,
		CodeActionParams params, CancelIndicator indicator) {
		val actions = newArrayList
		for (d : params.context.diagnostics) {
			if (d.code == IssueCodes.WARNING_SOLIDITY_VERSION_NOT_THE_DEFAULT) {
				actions += Either.forRight(new CodeAction => [
					title = '''Change to «solcVersion»'''
					diagnostics = #[d]
					edit = new WorkspaceEdit() => [
						addTextEdit(resource.URI, new TextEdit => [
							range = d.range
							newText = solcVersion
						])
					]
				])
			}
		}
		return actions
	}

	protected def addTextEdit(WorkspaceEdit edit, URI uri, TextEdit... textEdit) {
		edit.changes.put(uri.toString, textEdit)
	}

}
