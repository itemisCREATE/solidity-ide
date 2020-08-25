import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { Engine, Plugin, Profile } from '@remixproject/engine';
import { Observable } from 'rxjs';
import { EclipseService } from '../eclipse/eclipse-api';
import { YakinduPluginManager } from './plugin-manager';
import { EclipsePluginConnector } from './plugins/eclipse-plugin';
import { YakinduProxy } from './plugins/yakindu';

const PLUGIN_DIRECTORY = 'https://raw.githubusercontent.com/ethereum/remix-plugins-directory/master/build/metadata.json';

const solidityProfile = {
  name: 'solidity',
  displayName: 'Solidity compiler',
  icon: 'https://solidity.readthedocs.io/en/v0.6.10/_images/logo.svg',
  description: 'Compile solidity contracts',
  kind: 'compiler',
  permission: true,
  location: 'sidePanel',
  documentation: 'https://remix-ide.readthedocs.io/en/latest/solidity_editor.html',
  version: '0.0.1',
  methods: ['getCompilationResult', 'compile', 'compileWithParameters', 'setCompilerConfig'],
  url: 'ipfs://QmNgz8ecPPbdvjjzy1UfRTeuN5jN2fTeAJB93zU8FtFrqF'
  // url: 'https://ipfs.io/ipfs/QmNgz8ecPPbdvjjzy1UfRTeuN5jN2fTeAJB93zU8FtFrqF'
};

const editorProfile = {
  displayName: 'YAKINDU Editor',
  name: 'editor',
  description: 'service - editor',
  version: '0.0.1',
  methods: ['highlight', 'discardHighlight', 'discardHighlightAt', 'clearAnnotations', 'addAnnotation'],
  url: ''
};

const fileManagerPofile = {
  name: 'fileManager',
  displayName: 'Eclipse file system',
  description: 'Service - read/write to any files or folders, require giving permissions',
  icon: 'assets/img/fileManager.webp',
  permission: true,
  version: '0.0.1',
  methods: ['file', 'exists', 'open', 'writeFile', 'readFile', 'copyFile', 'rename', 'mkdir', 'readdir', 'remove', 'getCurrentFile', 'getFile', 'getFolder', 'setFile', 'switchFile'],
  kind: 'file-system',
  url: ''
};

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

  profiles: Observable<Profile[]>;

  constructor(private eclipseService: EclipseService, private http: HttpClient) {
    this.profiles = this.http.get<Profile[]>(PLUGIN_DIRECTORY);
  }

  ngOnInit(): void {
    // createIframeClient(solidityProfile);
    this.engine.register(new Plugin(solidityProfile));
    this.engine.register(new EclipsePluginConnector(editorProfile, this.eclipseService.nativeEclipse));
    this.engine.register(new EclipsePluginConnector(fileManagerPofile, this.eclipseService.nativeEclipse));
    const yakindu = new YakinduProxy(this.eclipseService.nativeEclipse);
    this.engine.register(yakindu);
    this.manager.activatePlugin(solidityProfile.name);
    this.manager.activatePlugin(editorProfile.name);
    this.manager.activatePlugin(fileManagerPofile.name);
    this.manager.activatePlugin(yakindu.name);
    // .then(() => {
    //   yakindu.call('YAKINDU', 'doIt').then((result) => alert('Current file is: ' + result));
    // });
  }

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

}
