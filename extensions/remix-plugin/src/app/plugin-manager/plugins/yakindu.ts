import { Message } from '@remixproject/engine';
import { EclipseIDE } from 'src/app/eclipse/eclipse-api';
import { EclipseClientConnector, EclipsePluginConnector } from './eclipse-plugin';

export class YakinduProxy extends EclipsePluginConnector {
  response: Promise<any>;

  constructor(eclipse: EclipseIDE) {
    super({
      name: 'YAKINDU',
      displayName: 'YAKINDU IDE',
      methods: ['doIt'],
      url: ''
    }, eclipse);


    const connector = new EclipseClientConnector().on((message: Partial<Message>) => {
      this.response = this.getMessage(message as Message);
      //this.getMessage(message as Message).then((result) => alert('The result is: ' + result));
    });
  }

  protected callPluginMethod(key: string): Promise<any> {
    if (key === 'doIt') {
      this.doIt();
    }
    return;
  }

  private doIt(): Promise<any> {
    this.call('fileManager', 'getCurrentFile').then((res) => alert('Current file is ' + res));
    return this.response;
  }
}
