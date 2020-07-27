import { PluginConnector, Profile, ExternalProfile } from '@remixproject/engine';
import { ClientConnector, Message } from '@remixproject/plugin';
import stringify from 'fast-stringify';
import { EclipseIDE } from 'src/app/eclipse/eclipse-api';

export class EclipsePluginConnector extends PluginConnector {


  constructor(profile: Profile & ExternalProfile, private eclipse: EclipseIDE) {
    super(profile);
  }

  // Send message to Eclipse
  send(message: Partial<Message>): void {
    this.eclipse.eclipse_send(stringify(message));
  }

  // on(cb: (message: Message) => void): void {

  // }

  protected connect(url: string): void {
    this.eclipse.eclipse_connect(stringify(this.profile));
  }

  protected disconnect(): void {
    this.eclipse.eclipse_disconnect(this.profile.name);
  }
}

class EclipseClientConnector implements ClientConnector {

  listener: (message: Partial<Message>) => void;

  constructor() {
    document.addEventListener('on_eclipse', (event: CustomEvent) => this.listener.call((event.detail as Message)));
  }

  send(message: Partial<Message>): void {
    this.listener.call(message);
  }
  on(cb: (message: Partial<Message>) => void): void {
    this.listener = cb;
  }

}
