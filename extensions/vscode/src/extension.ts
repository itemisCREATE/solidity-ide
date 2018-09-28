'use strict';

import * as path from 'path';
import * as os from 'os';

import { Trace } from 'vscode-jsonrpc';
import { commands, window, workspace, ExtensionContext, Uri } from 'vscode';
import { LanguageClient, LanguageClientOptions, ServerOptions } from 'vscode-languageclient';

export function activate(context: ExtensionContext) {
    // The server is a locally installed in src/ls
    let launcher = os.platform() === 'win32' ? 'solidity-ls.bat' : 'solidity-ls';
    let script = context.asAbsolutePath(path.join('src', 'ls', 'bin', launcher));
    console.log("Activating Solidity LS " + script)
    
    let serverOptions: ServerOptions = {
        run : { command: script },
        debug: { command: script, args: ['-Xdebug','-Xrunjdwp:server=y,transport=dt_socket,address=7777,suspend=n,quiet=y','-Xmx256m'] }
    };
    
    let clientOptions: LanguageClientOptions = {
        documentSelector: ['sol'],
        synchronize: {
            fileEvents: workspace.createFileSystemWatcher('**/*.*')
        }
    };
    
    // Create the language client and start the client.
    let lc = new LanguageClient('Solidity LS', serverOptions, clientOptions);
    
    var disposable2 =commands.registerCommand("sol.a.proxy", async () => {
        let activeEditor = window.activeTextEditor;
        if (!activeEditor || !activeEditor.document || activeEditor.document.languageId !== 'sol') {
            return;
        }

        if (activeEditor.document.uri instanceof Uri) {
            commands.executeCommand("sol.a", activeEditor.document.uri.toString());
        }
    })
    context.subscriptions.push(disposable2);
    
    // enable tracing (.Off, .Messages, Verbose)
    lc.trace = Trace.Verbose;
    let disposable = lc.start();
    
    // Push the disposable to the context's subscriptions so that the 
    // client can be deactivated on extension deactivation
    context.subscriptions.push(disposable);
}