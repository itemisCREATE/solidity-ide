import { Message } from '@remixproject/engine';
import { EclipseIDE } from '../../../app/eclipse/eclipse-api';
import { EclipsePluginConnector } from './eclipse-plugin';

export class YakinduProxy extends EclipsePluginConnector {


  constructor(eclipse: EclipseIDE) {
    super({
      name: 'YAKINDU',
      displayName: 'YAKINDU IDE',
      methods: ['doIt'],
      url: ''
    }, eclipse);
  }

  protected callPluginMethod(key: string): Promise<any> {
    if (key === 'doIt') {
      this.doIt();
    }
    return;
  }

  private doIt(): Promise<any> {
    return this.call('fileManager', 'getCurrentFile').then((res) => alert('Current file is ' + res));
  }
}
