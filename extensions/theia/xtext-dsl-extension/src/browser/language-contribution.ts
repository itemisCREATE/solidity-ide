import { injectable, inject } from 'inversify';
import { Workspace, Languages, LanguageClientFactory, BaseLanguageClientContribution } from '@theia/languages/lib/browser';
import { MessageService } from "@theia/core/lib/common";

@injectable()
export class DslClientContribution extends BaseLanguageClientContribution {

    readonly id = "solidity";
    readonly name = "com.yakindu.solidity.Solidity";

    constructor(
        @inject(Workspace) protected readonly workspace: Workspace,
        @inject(Languages) protected readonly languages: Languages,
        @inject(LanguageClientFactory) protected readonly languageClientFactory: LanguageClientFactory,
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
}

// register language with monaco on first load
registerDSL();

export function registerDSL() {
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