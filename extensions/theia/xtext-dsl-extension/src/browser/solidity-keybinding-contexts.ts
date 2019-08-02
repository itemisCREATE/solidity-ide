/********************************************************************************
 * Copyright (C) 2018 TypeFox and others.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License v. 2.0 are satisfied: GNU General Public License, version 2
 * with the GNU Classpath Exception which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 ********************************************************************************/

import { injectable } from 'inversify';
import { EditorTextFocusContext, EditorWidget } from '@theia/editor/lib/browser';
import { SOLIDITY_LANGUAGE_ID } from '../common';

export namespace SolidityKeybindingContexts {
    export const solidityEditorTextFocus = 'solidityEditorTextFocus';
}

@injectable()
export class SolidityEditorTextFocusContext extends EditorTextFocusContext {

    readonly id: string = SolidityKeybindingContexts.solidityEditorTextFocus;

    protected canHandle(widget: EditorWidget): boolean {
        return super.canHandle(widget) && widget.editor.document.languageId === SOLIDITY_LANGUAGE_ID;
    }

}
