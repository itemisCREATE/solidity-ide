import { Component, Input, OnInit } from '@angular/core';
// import { EclipseInPlugin } from './plugins/eclipse-plugin';
import { Engine, Plugin, PluginManager, Message } from '@remixproject/engine';
import { EclipseService } from '../eclipse/eclipse-api';
import { EclipsePluginConnector, EclipseClientConnector } from './plugins/eclipse-plugin';
import { YakinduProxy } from './plugins/yakindu';


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
  manager: PluginManager;

  @Input()
  engine: Engine;

  constructor(private eclipseService: EclipseService) { }

  ngOnInit(): void {
    this.engine.register(new Plugin(solidityProfile));
    this.engine.register(new EclipsePluginConnector(editorProfile, this.eclipseService.nativeEclipse));
    this.engine.register(new EclipsePluginConnector(fileManagerPofile, this.eclipseService.nativeEclipse));
    const yakindu = new YakinduProxy(this.eclipseService.nativeEclipse);
    this.engine.register(yakindu);
    this.manager.activatePlugin(solidityProfile.name);
    this.manager.activatePlugin(editorProfile.name);
    this.manager.activatePlugin(fileManagerPofile.name);
    this.manager.activatePlugin(yakindu.name).then(() => {
      yakindu.call('YAKINDU', 'doIt').then((result) => alert('Current file is: ' + result));
    });
  }
}
