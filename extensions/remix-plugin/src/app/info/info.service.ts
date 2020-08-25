import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class AlertService {
  alerts: Observable<string>;
  private update: (value: string) => void;


  constructor() {
    this.alerts = new Observable(observer => {
      this.update = (value: string) => {
        observer.next(value);
      };
    });
  }

  public raiseAlert(message: string): void {
    this.update(message);
  }
}
