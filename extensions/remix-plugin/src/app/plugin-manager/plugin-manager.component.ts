
import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { Engine, Plugin, Profile } from '@remixproject/engine';
import { ExternalProfile } from '@remixproject/plugin';
import { Observable } from 'rxjs';
import { YakinduPluginManager } from '../plugin-manager';

const PLUGIN_DIRECTORY = 'https://raw.githubusercontent.com/ethereum/remix-plugins-directory/master/build/metadata.json';

@Component({
  selector: 'app-plugin-manager',
  templateUrl: './plugin-manager.component.html',
  styleUrls: ['./plugin-manager.component.css']
})
export class PluginManagerComponent implements OnInit {

  @Input()
  manager: YakinduPluginManager;

  @Input()
  engine: Engine;

  profiles: Observable<any[]>;

  constructor(private http: HttpClient) {
    this.profiles = this.http.get<Profile & ExternalProfile[]>(PLUGIN_DIRECTORY);
  }

  ngOnInit(): void { }

  isActive(name: string): Observable<boolean> {
    return new Observable<boolean>((observer) => {
      observer.next(false);
      this.isRegistered(name).subscribe((registered) => {
        if (registered) {
          this.manager.isActive(name).then((value) => observer.next(value));
        }
      });
    });
  }

  isRegistered(name: string): Observable<boolean> {
    return new Observable<boolean>((observer) => {
      const registered = this.engine.isRegistered(name);
      observer.next(registered);
    });
  }

  async activatePlugin(profile: Profile & ExternalProfile): Promise<void> {
    if (! await this.isRegistered(profile.name)) {
      this.engine.register(new Plugin(profile));
    }
    if (await this.isActive(profile.name)) {
      return;
    }
  }
}
