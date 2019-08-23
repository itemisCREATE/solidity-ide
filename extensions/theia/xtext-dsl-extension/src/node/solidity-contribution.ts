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

import * as os from 'os';
import * as path from 'path';
import { Socket } from 'net';
import { injectable } from 'inversify';
import { createSocketConnection } from 'vscode-ws-jsonrpc/lib/server';
import { IConnection, BaseLanguageServerContribution, LanguageServerStartOptions } from '@theia/languages/lib/node';
import { SOLIDITY_LANGUAGE_ID, SOLIDITY_LANGUAGE_NAME, SolidityStartParams } from '../common';

export interface SolidityStartOptions extends LanguageServerStartOptions {
    parameters?: SolidityStartParams
}

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
export class SolidityContribution extends BaseLanguageServerContribution {

    readonly id = SOLIDITY_LANGUAGE_ID;
    readonly name = SOLIDITY_LANGUAGE_NAME;

    constructor() {
        super();
        // this.activeDataFolders = new Set<string>();
    }

    start(clientConnection: IConnection) {
        const socketPort = getPort();
        if (socketPort) {
            const socket = new Socket();
            const serverConnection = createSocketConnection(socket, socket, () => socket.destroy());
            this.forward(clientConnection, serverConnection);
            socket.connect(socketPort);
            return;
        } else {
            const ops = os.platform();
            
            let command = path.resolve(__dirname, '../../languageserver/bin/solidity-ls');
            if (ops == "win32"){
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
        console.info('+++++++++++++++' + JSON.stringify(dataString, handleCircles));
    }

    // protected map(message: Message): Message {
    //     return  super.map(message);
    // }
}
