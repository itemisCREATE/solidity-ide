import { Injectable } from '@angular/core';

export interface EclipseIDE extends Window {
  // Ask Eclipse to create a Browser instance. Return the id of the browser instance
  eclipse_connect: (profile: string) => string;

  // Ask Eclipse to destroy a Browser instance
  eclipse_disconnect: (id: string) => boolean;

  // Send a message to Eclipse
  eclipse_send: (message: string) => void;
}

function getWindow(): any {
  return window;
}

@Injectable({
  providedIn: 'root'
})
export class EclipseService {

  constructor() { }

  get nativeEclipse(): EclipseIDE {
    return getWindow();
  }
}
