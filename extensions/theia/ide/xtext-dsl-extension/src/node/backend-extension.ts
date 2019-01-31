/*
 * Copyright (C) 2017 TypeFox and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 */

import { injectable, ContainerModule } from "inversify";
import { BaseLanguageServerContribution, LanguageServerContribution, IConnection } from "@theia/languages/lib/node";
import { createSocketConnection } from 'vscode-ws-jsonrpc/lib/server';
import * as cp from 'child_process';
import * as net from 'net';
import * as path from 'path';
import * as os from 'os';
import { Message } from 'vscode-ws-jsonrpc';
import { MaybePromise } from "@theia/core/lib/common";
import { RawProcess } from '@theia/process/lib/node/raw-process';


export default new ContainerModule(bind => {
    bind<LanguageServerContribution>(LanguageServerContribution).to(DSLContribution);
});

function getPort(): number | undefined {
    let arg = process.argv.filter(arg => arg.startsWith('--LSP_PORT='))[0];
    if (!arg) {
        return undefined;
    } else {
        return Number.parseInt(arg.substring('--LSP_PORT='.length));
    }
}

function handleCircles(key: String, value: any) {
    var cache :any = [];
    if (typeof value === 'object' && value !== null) {
        if (cache.indexOf(value) !== -1) {
            // Duplicate reference found
            try {
                // If this value does not reference a parent it can be deduped
                return JSON.parse(JSON.stringify(value));
            } catch (error) {
                // discard key if value cannot be deduped
                return;
            }
        }
        // Store value in our collection
        cache.push(value);
    }
    return value;
}

@injectable()
class DSLContribution extends BaseLanguageServerContribution {

    readonly id = "solidity";
    readonly name = "com.yakindu.solidity.Solidity";

    //Starts the server
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
            
            var command = path.resolve(__dirname, '../../lsp/bin/solidity-ls');
            if (ops.toLowerCase().includes("win")){
                command += ".bat"
            }
    
            const args: string[] = [];
            const serverConnection = this.createProcessStreamConnection(command, args);
            this.forward(clientConnection, serverConnection);
        }
    }

    protected onDidFailSpawnProcess(error: Error): void {
        super.onDidFailSpawnProcess(error);

        console.error("Error starting DSL language server.", error);
    }

    //Similar to start
    protected forward(clientConnection: IConnection, serverConnection: IConnection): void {
        super.forward(clientConnection, serverConnection);
    }

    //RPC Massages
    protected map(message: Message): Message {
        var result = super.map(message);

        return result;
    }

    protected createProcessSocketConnection(outSocket: MaybePromise<net.Socket>, inSocket: MaybePromise<net.Socket>, command: string, args?: string[], options?: cp.SpawnOptions): Promise<IConnection> {
        var result = super.createProcessSocketConnection(outSocket, inSocket, command, args, options);

        return result
    }

    //Similar to span Process
    protected createProcessStreamConnection(command: string, args?: string[], options?: cp.SpawnOptions): IConnection {
        var result = super.createProcessStreamConnection(command, args, options);

        return result
    }

    //Create the Process, command contiins path to script, LSP for example    
    protected spawnProcess(command: string, args?: string[], options?: cp.SpawnOptions): RawProcess {
        var result = super.spawnProcess(command, args, options);

        return result
    }

    
    protected logError(data: string | Buffer): void {
        super.logError(data);

        var dataString : string = "";
        if (typeof data === "string"){
            dataString = data;
        } else {
            data.forEach(function(value:number, index:number, array:Uint8Array){
                dataString += String.fromCharCode(value);
            })
        }
        console.error("with data: " + JSON.stringify(dataString, handleCircles));
    }

    
    protected logInfo(data: string | Buffer): void {
        super.logInfo(data);

        var dataString : string = "";
        if (typeof data === "string"){
            dataString = data;
        } else {
            data.forEach(function(value:number, index:number, array:Uint8Array){
                dataString += String.fromCharCode(value);
            })
        }
        console.info(JSON.stringify(dataString, handleCircles));
    }

    
    protected startSocketServer(): Promise<net.Server> {
        var result = super.startSocketServer();

        return result
    }

    
    protected accept(server: net.Server): Promise<net.Socket> {
        var result = super.accept(server);

        return result
    }
}