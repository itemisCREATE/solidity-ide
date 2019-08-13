/********************************************************************************
 * Copyright (C) 2017 TypeFox and others.
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

import { inject, injectable } from 'inversify';
import { CommandContribution, CommandRegistry, Command, MenuContribution, MenuModelRegistry } from '@theia/core/lib/common';
import { EDITOR_CONTEXT_MENU, EditorManager, EditorWidget } from '@theia/editor/lib/browser';
import { KeybindingContribution, KeybindingRegistry } from '@theia/core/lib/browser';
import { SOLIDITY_LANGUAGE_ID } from '../common';
import { SolidityClientContribution } from './solidity-client-contribution';
import { SolidityKeybindingContexts } from './solidity-keybinding-contexts';
import { CompileWorkspaceRequest, CompileWorkspaceStatus } from './solidity-protocol';

export const SOLIDITY_COMPILE_WORKSPACE: Command = {
    id: 'solidity.compile',
    label: 'compile solidity'
};

@injectable()
export class SolidityCommandContribution implements CommandContribution, MenuContribution, KeybindingContribution {

    constructor(
        @inject(EditorManager) protected readonly editorManager: EditorManager,
        @inject(SolidityClientContribution) protected readonly solidityClientContribution: SolidityClientContribution
    ){
        console.info("++++++++++++++++++++SolidityCommandContribution Constructor")}

    registerCommands(commands: CommandRegistry): void {
        commands.registerCommand(SOLIDITY_COMPILE_WORKSPACE, {
            execute: async (fullCompile: boolean) => {
                const languageClient = await this.solidityClientContribution.languageClient;
                const result = await languageClient.sendRequest(CompileWorkspaceRequest.type.method, fullCompile);
                if (result === CompileWorkspaceStatus.SUCCEED) {
                    return;
                }
                throw new Error('Failed to build');
            },
            isEnabled: () => this.solidityClientContribution.running
        });
    }

    get currentEditor(): EditorWidget | undefined {
        const { currentEditor } = this.editorManager;
        if (currentEditor && currentEditor.editor.document.languageId === SOLIDITY_LANGUAGE_ID) {
            return currentEditor;
        }
        return undefined;
    }

    registerMenus(menus: MenuModelRegistry): void {
        menus.registerMenuAction([...EDITOR_CONTEXT_MENU, '1_modification'], {
            commandId: SOLIDITY_COMPILE_WORKSPACE.id,
            label: 'Organize Imports'
        });
    }

    registerKeybindings(keybindings: KeybindingRegistry): void {
        keybindings.registerKeybinding({
            command: SOLIDITY_COMPILE_WORKSPACE.id,
            context: SolidityKeybindingContexts.solidityEditorTextFocus,
            keybinding: 'shift+alt+c'
        });
    }
}
