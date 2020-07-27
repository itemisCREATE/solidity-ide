import { PluginConnector, Profile, ExternalProfile, Message } from '@remixproject/engine';
import { ClientConnector } from '@remixproject/plugin';
import stringify from 'fast-stringify';
import { EclipseIDE } from 'src/app/eclipse/eclipse-api';
import { Yakindu } from './yakindu';

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
}

export class EclipseClientConnector implements ClientConnector {

  cb: (message: Partial<Message>) => void;

  constructor() {
    document.addEventListener('on_eclipse', (event: CustomEvent) => this.send(event.detail as Message));
  }

  send(message: Partial<Message>): void {
    alert('ClientConnector#send ' + message.name);
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
