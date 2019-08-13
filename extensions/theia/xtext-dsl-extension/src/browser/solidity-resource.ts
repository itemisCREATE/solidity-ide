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
import URI from '@theia/core/lib/common/uri';
import { Resource, ResourceResolver } from '@theia/core/lib/common';
import { SOLIDITY_SCHEME } from '../common';
import { ClassFileContentsRequest } from './solidity-protocol';
import { SolidityClientContribution } from './solidity-client-contribution';

export class SolidityResource implements Resource {

    constructor(
        public uri: URI,
        protected readonly clientContribution: SolidityClientContribution
    ) { }

    dispose(): void {
    }

    readContents(options: { encoding?: string }): Promise<string> {
        const uri = this.uri.toString();
        return this.clientContribution.languageClient.then(lc =>
            lc.sendRequest(ClassFileContentsRequest.type.method, { uri }).then(content =>
                content.toString() || ''
            )
        );
    }

}

@injectable()
export class SolidityResourceResolver implements ResourceResolver {

    constructor(
        @inject(SolidityClientContribution)
        protected readonly clientContribution: SolidityClientContribution
    ) {
        console.info("++++++++++++++++++++++++++SolidityResourceResolver Constructor")}

    resolve(uri: URI): SolidityResource {
        if (uri.scheme !== SOLIDITY_SCHEME) {
            throw new Error('The given URI is not a valid Solidity uri: ' + uri);
        }
        return new SolidityResource(uri, this.clientContribution);
    }

}
