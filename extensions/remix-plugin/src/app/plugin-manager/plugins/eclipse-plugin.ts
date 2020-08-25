import { PluginConnector, Profile, ExternalProfile, Message } from '@remixproject/engine';
import { ClientConnector } from '@remixproject/plugin';
import stringify from 'fast-stringify';
import { EclipseIDE } from '../../eclipse/eclipse-api';
import { YakinduProxy } from './yakindu';

export class EclipsePluginConnector extends PluginConnector {


  constructor(profile: Profile & ExternalProfile, private eclipse: EclipseIDE) {
    super(profile);
  }

  // Send message to Eclipse
  send(message: Partial<Message>): void {
    this.eclipse.eclipse_send(stringify(message));
  }

  protected connect(url: string): void {
    this.eclipse.eclipse_connect(stringify(this.profile));
  }

  protected disconnect(): void {
    this.eclipse.eclipse_disconnect(this.profile.name);
  }

  protected getMessage(message : Message): Promise<any> {
    alert('EclipsePluginConnector#getMessage');
    alert('payload is: ' + message.payload)
    return new Promise((resolve, reject) => {
      resolve(message.payload);
    });
  }
}

export class EclipseClientConnector implements ClientConnector {

  cb: (message: Partial<Message>) => void;

  constructor() {
    document.addEventListener('on_eclipse', (event: CustomEvent) => this.send(event.detail as Message));
  }

  send(message: Partial<Message>): void {
    this.cb.call(this, message);
  }

  on(cb: (message: Partial<Message>) => void): void {
    alert('registered callback');
    this.cb = cb;
  }

  // processEvent(message: Partial<Message>): void {
  //   alert('EclipseClientConnector#processEvent');
  //   if (message.name === this.plugin.name) {
  //     alert('received');
  //     this.plugin.call('solidity', 'compile');
  //   }
  // }

}
