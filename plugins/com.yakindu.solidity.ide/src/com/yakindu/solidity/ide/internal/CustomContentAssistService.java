package com.yakindu.solidity.ide.internal;
import org.eclipse.lsp4j.CompletionItem;
import org.eclipse.lsp4j.MarkupContent;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.contentassist.ContentAssistService;

public class CustomContentAssistService extends ContentAssistService {
	
	@Override
	protected CompletionItem toCompletionItem(ContentAssistEntry entry, int caretOffset, Position caretPosition,
			Document document) {
		CompletionItem completionItem = super.toCompletionItem(entry, caretOffset, caretPosition, document);
		Either<String, MarkupContent> documentation = completionItem.getDocumentation();
		if (documentation != null && documentation.getLeft() == null && documentation.getRight()==null) {
			completionItem.setDocumentation((Either<String,MarkupContent>)null);
		}
		return completionItem;
	}

}