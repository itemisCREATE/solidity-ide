import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent, SafePipe } from './app.component';
import { PluginManagerComponent } from './plugin-manager/plugin-manager.component';
import { HttpClientModule } from '@angular/common/http';
import { PluginViewComponent } from './plugin-view/plugin-view.component';
import { PluginComponent } from './plugin-view/plugin/plugin.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    AppComponent,
    PluginManagerComponent,
    PluginViewComponent,
    SafePipe,
    PluginComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    NgbModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
