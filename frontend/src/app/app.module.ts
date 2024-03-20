import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { HomeModule } from './features/home/home.module';
import { ApiModule, BASE_PATH } from './generate/openapi';
import { environment } from './environments/environment.development';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [AppComponent],
  imports: [
    ApiModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    BrowserModule,
    HomeModule,
    HttpClientModule,
  ],
  providers: [{ provide: BASE_PATH, useValue: environment.apiBasePath }],
  bootstrap: [AppComponent],
})
export class AppModule {}
