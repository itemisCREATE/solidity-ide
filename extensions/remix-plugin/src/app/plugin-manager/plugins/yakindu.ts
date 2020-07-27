import { Message } from '@remixproject/engine';
import { EclipseIDE } from 'src/app/eclipse/eclipse-api';
import { EclipseClientConnector, EclipsePluginConnector } from './eclipse-plugin';

export class Yakindu extends EclipsePluginConnector {
  constructor(eclipse: EclipseIDE) {
    super({
      name: 'YAKINDU',
      displayName: 'YAKINDU IDE',
      methods: ['doIt'],
      url: ''
    }, eclipse);

    const connector = new EclipseClientConnector().on((message: Partial<Message>) => {
      alert('EclipseClientConnector#processEvent');
      alert('Message name is ' + message?.name);
      this.call(message.name, message.key);
    });
  }

  doIt(): void {
    alert('Yakindu#doIt');
    this.call('fileManager', 'getCurrentFile');
  }
}
