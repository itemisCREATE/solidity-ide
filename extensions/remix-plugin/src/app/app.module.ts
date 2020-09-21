import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent, SafePipe } from './app.component';
import { PluginManagerComponent } from './plugin-manager/plugin-manager.component';
import { PluginViewComponent } from './plugin-view/plugin-view.component';
import { PluginComponent } from './plugin-view/plugin/plugin.component';


@NgModule({
  declarations: [
    AppComponent,
    PluginManagerComponent,
    PluginViewComponent,
    SafePipe,
    PluginComponent,
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
