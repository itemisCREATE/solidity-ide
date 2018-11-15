/*
 * Copyright (C) 2017 TypeFox and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 */

import { injectable, ContainerModule } from "inversify";
import { BaseLanguageServerContribution, LanguageServerContribution, IConnection } from "@theia/languages/lib/node";
import { createSocketConnection } from 'vscode-ws-jsonrpc/lib/server';
import * as path from 'path';
import * as net from 'net';
import * as os from 'os';


export default new ContainerModule(bind => {
    bind<LanguageServerContribution>(LanguageServerContribution).to(DSLContribution);
});

function getPort(): number | undefined {
    let arg = process.argv.filter(arg => arg.startsWith('--LSP_PORT='))[0]
    if (!arg) {
        return undefined;
    } else {
        return Number.parseInt(arg.substring('--LSP_PORT='.length))
    }
}

@injectable()
class DSLContribution extends BaseLanguageServerContribution {

    readonly id = "solidity";
    readonly name = "com.yakindu.solidity.Solidity";

    start(clientConnection: IConnection): void {
        let socketPort = getPort();
        if (socketPort) {
            const socket = new net.Socket();
            const serverConnection = createSocketConnection(socket, socket, () => {
                socket.destroy();
            });
            this.forward(clientConnection, serverConnection);
            socket.connect(socketPort);
        } else {
            const ops = os.platform();
            
            console.info(ops);
            
            var command = path.resolve(__dirname, '../../lsp/bin/solidity-ls');
            if (ops.toLowerCase().includes("win")){
                command += ".bat"
            }
    
            console.info(command);

            const args: string[] = [];
            const serverConnection = this.createProcessStreamConnection(command, args);
            console.info("before forward");
            this.forward(clientConnection, serverConnection);
        }
    }

    protected onDidFailSpawnProcess(error: Error): void {
        super.onDidFailSpawnProcess(error);
        console.error("Error starting DSL language server.", error)
    }

}



