import { Component, OnInit, Pipe, PipeTransform } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { Engine, PluginManager } from '@remixproject/engine';
import { Observable } from 'rxjs';
import { YakinduPluginManager } from './plugin-manager/plugin-manager';

@Pipe({ name: 'safe' })
export class SafePipe implements PipeTransform {
  constructor(private sanitizer: DomSanitizer) { }
  transform(url) {
    return this.sanitizer.bypassSecurityTrustResourceUrl(url);
  }
}
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {
  manager: PluginManager;
  engine: Engine;
  loading: Observable<boolean>;

  ngOnInit(): void {
    this.manager = new YakinduPluginManager();
    this.engine = new Engine(this.manager);
    this.loading = new Observable<boolean>(cb => {
      cb.next(false);
      this.engine.onload().then(() => {
        console.log('Engine loaded');
        cb.next(true);
      });
    });
  }
}
