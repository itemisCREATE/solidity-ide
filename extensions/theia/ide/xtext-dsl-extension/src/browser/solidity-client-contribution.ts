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

 import { injectable, inject } from 'inversify';
import { MessageService, CommandService } from "@theia/core/lib/common";
import { MessageConnection } from 'vscode-jsonrpc';

import { SemanticHighlightingService } from '@theia/editor/lib/browser/semantic-highlight/semantic-highlighting-service';
import { Window, ILanguageClient, BaseLanguageClientContribution, Workspace, Languages, LanguageClientFactory, LanguageClientOptions } from '@theia/languages/lib/browser';
import { SOLIDITY_LANGUAGE_ID, SOLIDITY_LANGUAGE_NAME, SolidityStartParams } from '../common';
import { ActionableMessage } from './solidity-protocol';
import { MaybePromise } from '@theia/core';

@injectable()
export class SolidityClientContribution extends BaseLanguageClientContribution {

    readonly id = SOLIDITY_LANGUAGE_ID;
    readonly name = SOLIDITY_LANGUAGE_NAME;
    
    constructor(
        @inject(Workspace) protected readonly workspace: Workspace,
        @inject(Languages) protected readonly languages: Languages,
        @inject(LanguageClientFactory) protected readonly languageClientFactory: LanguageClientFactory,
        @inject(Window) protected readonly window: Window,
        @inject(CommandService) protected readonly commandService: CommandService,
        @inject(SemanticHighlightingService) protected readonly semanticHighlightingService: SemanticHighlightingService,
        @inject(MessageService) protected readonly messageService: MessageService
        ) {
            super(workspace, languages, languageClientFactory);
            messageService.info('This is only a test instance and will be destroyed in an hour!');
    }

    protected get globPatterns() {
        return [
            '**/*.sol'
        ];
    }

    protected get workspaceContains() {
        return [];
    }

    get configurationSection() {
        return 'solidity';
    }
    
    protected onReady(languageClient: ILanguageClient): void {
        super.onReady(languageClient);
    }

    protected createLanguageClient(connection: MessageConnection): ILanguageClient {
        const client: ILanguageClient & Readonly<{ languageId: string }> = Object.assign(super.createLanguageClient(connection), { languageId: this.id });
        client.registerFeature(SemanticHighlightingService.createNewFeature(this.semanticHighlightingService, client));
        return client;
    }

    protected showActionableMessage(message: ActionableMessage): void {
        const items = message.commands || [];
        this.window.showMessage(message.severity, message.message, ...items).then(command => {
            if (command) {
                const args = command.arguments || [];
                this.commandService.executeCommand(command.command, ...args);
            }
        });
    }

    protected createOptions(): LanguageClientOptions {
        const options = super.createOptions();
        options.initializationOptions = {
            extendedClientCapabilities: {
                classFileContentsSupport: true
            }
        };
        return options;
    }

    protected getStartParameters(): MaybePromise<SolidityStartParams> {
        const workspace = this.workspace.rootUri ? this.workspace.rootUri : undefined;
        return { workspace };
    }
}

// register language with monaco on first load
registerDSL();

export function registerDSL() {
    console.info("++++++++++++++++registerDSL");
    // initialize monaco
    monaco.languages.register({
        id: 'solidity',
        aliases: ['Solidity', 'solidity'],
        extensions: ['.sol'],
        mimetypes: ['text/sol']
    })
    monaco.languages.setLanguageConfiguration('solidity', {
        comments: {
            lineComment: "//",
            blockComment: ['/*', '*/']
        },
    })
    monaco.languages.setMonarchTokensProvider('solidity', <any>{
        // Set defaultToken to invalid to see what you do not tokenize yet
        // defaultToken: 'invalid',

        keywords: [
            'struct',
            'experimental',
            'years',
            'seconds',
            'payable',
            'evmasm',
            'else',
            'let',
            'if',
            'solidity',
            '!',
            'using',
            'mapping',
            'indexed',
            '%',
            'var',
            '&',
            'contract',
            '(',
            ')',
            'is',
            '*',
            'szabo',
            '+',
            ',',
            '-',
            'enum',
            '.',
            '/',
            'as',
            'returns',
            ':',
            ';',
            '<',
            '!=',
            '=',
            '>',
            '?',
            '**',
            '|=',
            'internal',
            ':=',
            'weeks',
            'library',
            '*=',
            'assembly',
            'wei',
            '[',
            'event',
            ']',
            '^',
            '_',
            '++',
            'break',
            '+=',
            'throw',
            'days',
            '{',
            '|',
            '}',
            '>>=',
            'return',
            '~',
            '||',
            '<<',
            '<=',
            'constant',
            'modifier',
            'while',
            'view',
            'continue',
            'function',
            '=:',
            '^=',
            '--',
            '==',
            'new',
            '=>',
            'minutes',
            'constructor',
            'pragma',
            '-=',
            'external',
            'null',
            '%=',
            '<<=',
            'finney',
            '>=',
            '&&',
            '>>',
            'private',
            'memory',
            'ether',
            'import',
            'for',
            'storage',
            'interface',
            'pure',
            'delete',
            'public',
            '&=',
            'hours',
            '/=',
            'emit'
        ],

        typeKeywords: [
        ],

        operators: [
        ],

        // we include these common regular expressions
        symbols: /[=><!~?:&|+\-*\/\^%]+/,
        escapes: /\\(?:[abfnrtv\\"']|x[0-9A-Fa-f]{1,4}|u[0-9A-Fa-f]{4}|U[0-9A-Fa-f]{8})/,

        // The main tokenizer for our languages
        tokenizer: {
            root: [
                // identifiers and keywords
                [/[a-z_$][\w$]*/, {
                    cases: {
                        '@keywords': 'keyword',
                        '@default': 'identifier'
                    }
                }],
                [/[A-Z][\w\$]*/, 'type.identifier'],  // to show class names nicely

                // whitespace
                { include: '@whitespace' },

                // delimiters and operators
                [/[{}()\[\]]/, '@brackets'],
                [/[<>](?!@symbols)/, '@brackets'],
                [/@symbols/, {
                    cases: {
                        '@operators': 'operator',
                        '@default': ''
                    }
                }]
            ],

            whitespace: [
                [/[ \t\r\n]+/, 'white'],
                [/\/\*/, 'comment', '@comment'],
                [/\/\/.*$/, 'comment'],
            ],

            comment: [
                [/[^\/*]+/, 'comment'],
                [/\/\*/, 'comment.invalid'],
                ["\\*/", 'comment', '@pop'],
                [/[\/*]/, 'comment']
            ],

            string: [
                [/[^\\"]+/, 'string'],
                [/@escapes/, 'string.escape'],
                [/\\./, 'string.escape.invalid'],
                [/"/, 'string', '@pop']
            ],
        },
    })
}