import { HttpClient } from '@angular/common/http';
import { AfterViewInit, Component, OnInit, Pipe, PipeTransform } from '@angular/core';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';
import { Engine, Plugin } from '@remixproject/engine';
import { IframePlugin, IframeProfile } from '@remixproject/engine-web';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { EclipseService } from './eclipse/eclipse-api';
import { YakinduPluginManager } from './plugin-manager';
import { EclipsePluginConnector } from './plugin-manager/plugins/eclipse-plugin';


const PLUGIN_DIRECTORY = 'https://raw.githubusercontent.com/ethereum/remix-plugins-directory/master/build/metadata.json';

const sidePanelProfile = {
  name: 'sidePanel',
  displayName: 'Side Panel',
  description: '',
  version: 'v0.10.3',
  methods: ['addView', 'removeView'],
  url: ''
};

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
  // url: 'ipfs://QmNgz8ecPPbdvjjzy1UfRTeuN5jN2fTeAJB93zU8FtFrqF'
  url: 'https://ipfsgw.komputing.org/ipfs/QmdtpU6puEJAHdedfsV6er1GpzfLPxZgiaTVdLnA65kx97/'
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
@Pipe({ name: 'safe' })
export class SafePipe implements PipeTransform {
  constructor(private sanitizer: DomSanitizer) { }
  transform(url): SafeResourceUrl {
    return this.sanitizer.bypassSecurityTrustResourceUrl(url);
  }
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, AfterViewInit {
  manager: YakinduPluginManager;
  engine: Engine;
  plugins: Promise<IframePlugin[]>;

  loading: Observable<boolean>;
  constructor(private eclipseService: EclipseService, http: HttpClient) {
    this.plugins = http.get<(IframeProfile)[]>(PLUGIN_DIRECTORY).pipe(
      map(profiles => profiles.map(p => new IframePlugin(p)))
    ).toPromise();
  }



  ngOnInit(): void {
    this.manager = new YakinduPluginManager();
    this.engine = new Engine(this.manager);
    this.loading = new Observable<boolean>(cb => {
      cb.next(false);
      this.engine.onload().then(() => {
        console.log('Engine loaded');
        this.registerAndActivateEclipseInterface().then((success) => cb.next(success));
      });
    });
  }

  ngAfterViewInit(): void {
  }

  async registerAndActivateEclipseInterface(): Promise<boolean> {
    // const yakindu = new YakinduProxy(this.eclipseService.nativeEclipse);
    const sidePanel = new EclipsePluginConnector(sidePanelProfile, this.eclipseService.nativeEclipse);
    const editor = new EclipsePluginConnector(editorProfile, this.eclipseService.nativeEclipse);
    const fileManager = new EclipsePluginConnector(fileManagerPofile, this.eclipseService.nativeEclipse);
    const compiler = new IframePlugin(solidityProfile);
    // this.engine.register(yakindu);
    this.engine.register(sidePanel);
    this.engine.register(editor);
    this.engine.register(fileManager);
    this.engine.register(compiler as unknown as Plugin);
    console.log('Essentials registered');
    return await this.activateEssentials([sidePanel, editor, fileManager, compiler as unknown as Plugin]);


    // compiler.call('solidity', 'compile', '/my/file.sol');
  }

  activateEssentials(plugins: Plugin[]): Promise<boolean> {
    const pluginsToActivate = plugins.map(p => p.name);
    return this.manager.activatePlugin(pluginsToActivate).then(
      () => {
        console.log('Essentials activated');
        this.manager.call('fileManager', 'getCurrentFile').then((res) => alert('Current file is ' + res));
        return true;
      },
      (error) => {
        console.error(error);
        return false;
      }
    );
  }
}
