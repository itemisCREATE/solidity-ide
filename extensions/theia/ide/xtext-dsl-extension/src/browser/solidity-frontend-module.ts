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

