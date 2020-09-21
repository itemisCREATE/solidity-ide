import { ExternalProfile, Message, PluginConnector, Profile } from '@remixproject/engine';
import stringify from 'fast-stringify';
import { EclipseIDE } from '../../eclipse/eclipse-api';

export class EclipsePluginConnector extends PluginConnector {


  constructor(profile: Profile & ExternalProfile, private eclipse: EclipseIDE) {
    super(profile);
  }

  isRunningInEclipse(): boolean {
    return this.eclipse.eclipse_connect !== undefined;
  }

  // Send message to Eclipse
  send(message: Partial<Message>): void {
    if (this.isRunningInEclipse()) {
      this.eclipse.eclipse_send(stringify(message));
    }
  }

  protected connect(url: string): void {
    if (this.isRunningInEclipse()) {
      this.eclipse.eclipse_connect(stringify(this.profile));
    }

    this.eclipse.document.addEventListener('message', (e: CustomEvent) => {
      console.log(e);
      this.getMessage(e.detail);
    });
  }

  protected disconnect(): void {
    if (this.isRunningInEclipse()) {
      this.eclipse.eclipse_disconnect(this.profile.name);
    }
    this.eclipse.document.removeEventListener('message', (e: CustomEvent) => {
      console.log(e);
      this.getMessage(e.detail);
    });
  }
}

// export class EclipseClientConnector implements ClientConnector {

//   cb: (message: Partial<Message>) => void;

//   constructor() {
//     // document.addEventListener('on_eclipse', (event: CustomEvent) => this.send(event.detail as Message));
//     // document.addEventListener('message', (event: CustomEvent) => {
//     //   alert(JSON.parse(event.detail));
//     //   this.send(JSON.parse(event.detail) as Message);
//     // }, false);
//   }

//   send(message: Partial<Message>): void {
//     this.cb.call(this, message);
//   }

//   on(cb: (message: Partial<Message>) => void): void {
//     alert('registered callback');
//     this.cb = cb;
//   }
// }
