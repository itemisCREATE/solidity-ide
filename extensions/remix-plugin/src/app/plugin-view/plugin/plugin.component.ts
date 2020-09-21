import { Component, OnInit, Input, AfterViewInit, ViewChild, ElementRef, Renderer2 } from '@angular/core';
import { IframeProfile } from '@remixproject/engine-web';

@Component({
  selector: 'app-plugin',
  templateUrl: './plugin.component.html',
  styleUrls: ['./plugin.component.css']
})
export class PluginComponent implements OnInit, AfterViewInit {

  @Input()
  profile: IframeProfile;

  @ViewChild('pluginContainer') pluginContainer!: ElementRef;

  constructor(private renderer: Renderer2) { }

  ngOnInit(): void {
  }

  ngAfterViewInit(): void {
    console.log();
    const iframe = this.renderer.createElement('iframe');
    this.renderer.setAttribute(iframe, 'src', this.profile.url);
    this.renderer.setAttribute(iframe, 'style', 'width:100%; height:100%;');
    this.renderer.listen(iframe, 'load', () => {
      console.log('onload ' + this.profile.name);
    });
    this.pluginContainer.nativeElement.append(iframe);
  }
}
