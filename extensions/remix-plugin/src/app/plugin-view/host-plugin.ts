import { HostPlugin, Profile } from '@remixproject/engine';

export class YakinduHostPlugin extends HostPlugin {

  inFocus: string = undefined;
  private addViewCb: (profile: Profile<any>, view: Element) => void;
  private removeViewCb: (profile: Profile<any>) => void;

  constructor(profile: Profile<any>) {
    super(profile);
  }

  setAddView(cb: (profile: Profile<any>, view: Element) => void): void {
    this.addViewCb = cb;
  }
  setRemoveView(cb: (profile: Profile<any>) => void): void {
    this.removeViewCb = cb;
  }


  currentFocus(): string {
    return this.inFocus;
  }
  focus(name: string): void {
    this.inFocus = name;
  }
  addView(profile: Profile<any>, view: Element): void {
    // if (this.addViewCb !== undefined) {
    //   console.log('YakinduHostPlugin#addView(' + profile.name + ')');
    //   return this.addViewCb?.call(this, profile, view);
    // }
  }
  removeView(profile: Profile<any>): void {
    // if (this.inFocus === profile.name) {
    //   this.inFocus = undefined;
    // }
    // return this.removeViewCb?.call(this, profile);
  }




  // add(view, name): void {
  //   if (this.contents[name]) throw new Error(`Plugin ${name} already rendered`)
  //   view.style.height = '100%'
  //   view.style.width = '100%'
  //   view.style.border = '0'

  //   const isIframe = view.tagName === 'IFRAME'
  //   view.style.display = isIframe ? 'none' : 'block'
  //   const loading = isIframe ? yo`
  //     <div class="d-flex justify-content-center align-items-center">
  //       <div class="spinner-border" role="status">
  //         <span class="sr-only">Loading...</span>
  //       </div>
  //     </div>
  //   ` : ''
  //   this.contents[name] = yo`<div class="${css.plugItIn}" >${view}${loading}</div>`

  //   if (view.tagName === 'IFRAME') {
  //     view.addEventListener('load', () => {
  //       if (this.contents[name].contains(loading)) {
  //         this.contents[name].removeChild(loading)
  //       }
  //       view.style.display = 'block'
  //     })
  //   }
  //   this.contents[name].style.display = 'none'
  //   this.view.appendChild(this.contents[name])
  // }
}
