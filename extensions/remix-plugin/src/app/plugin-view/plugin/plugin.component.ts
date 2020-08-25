import { Component, OnInit, Input } from '@angular/core';
import { Profile, ExternalProfile } from '@remixproject/engine';
import { YakinduPluginManager } from 'src/app/plugin-manager/plugin-manager';
import { from, Observable } from 'rxjs';

@Component({
  selector: 'app-plugin',
  templateUrl: './plugin.component.html',
  styleUrls: ['./plugin.component.css']
})
export class PluginComponent implements OnInit {

  @Input()
  manager: YakinduPluginManager;

  @Input()
  pluginName: string;
  profile: Observable<ExternalProfile & Profile<any>>;

  constructor() { }

  ngOnInit(): void {
    this.profile = from((this.manager.getProfile(this.pluginName).then(p => p as ExternalProfile & Profile<any>))) ;
  }

}
