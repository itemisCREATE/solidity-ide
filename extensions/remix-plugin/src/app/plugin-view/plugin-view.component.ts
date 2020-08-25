import { Component, Input, OnInit } from '@angular/core';
import { Engine, Profile } from '@remixproject/engine';
import { Observable } from 'rxjs';
import { YakinduPluginManager } from '../plugin-manager/plugin-manager';

@Component({
  selector: 'app-plugin-view',
  templateUrl: './plugin-view.component.html',
  styleUrls: ['./plugin-view.component.css']
})
export class PluginViewComponent implements OnInit {

  @Input()
  manager: YakinduPluginManager;

  @Input()
  engine: Engine;



  constructor() {}
  ngOnInit(): void {
  }

}
