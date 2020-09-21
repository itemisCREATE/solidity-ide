import { ExternalProfile, PluginManager, Profile } from '@remixproject/engine';
import { IframeProfile } from '@remixproject/engine-web';
export class YakinduPluginManager extends PluginManager {

  activeProfiles: IframeProfile[] = [];

  onPluginActivated(profile: Profile): void {
    if (profile.name !== 'manager' && profile.name !== 'editor' && profile.name !== 'fileManager' && profile.name !== 'sidePanel') {
      this.activeProfiles.push(profile as unknown as IframeProfile);
    }

  }

}
