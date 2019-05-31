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

 import { ContainerModule } from 'inversify';
import { ResourceResolver, CommandContribution, MenuContribution } from '@theia/core/lib/common';
import { KeybindingContribution, KeybindingContext } from '@theia/core/lib/browser';
import { LanguageClientContribution } from '@theia/languages/lib/browser';
import { LabelProviderContribution } from '@theia/core/lib/browser/label-provider';

import { SolidityClientContribution } from "./solidity-client-contribution";

import { SolidityCommandContribution } from './solidity-commands';
import { SolidityLabelProviderContribution } from './solidity-label-provider';
import { SolidityResourceResolver } from './solidity-resource';
import { SolidityEditorTextFocusContext } from './solidity-keybinding-contexts';


export default new ContainerModule(bind => {
    console.info("++++++++++++++++bind frontend");
    bind(SolidityCommandContribution).toSelf().inSingletonScope();
    bind(CommandContribution).toService(SolidityCommandContribution);
    bind(KeybindingContribution).toService(SolidityCommandContribution);
    bind(MenuContribution).toService(SolidityCommandContribution);

    bind(SolidityClientContribution).toSelf().inSingletonScope();
    bind(LanguageClientContribution).toService(SolidityClientContribution);

    bind(KeybindingContext).to(SolidityEditorTextFocusContext).inSingletonScope();

    bind(SolidityResourceResolver).toSelf().inSingletonScope();
    bind(ResourceResolver).toService(SolidityResourceResolver);

    bind(LabelProviderContribution).to(SolidityLabelProviderContribution).inSingletonScope();
})

