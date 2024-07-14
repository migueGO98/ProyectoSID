import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { ApiModule, BASE_PATH } from './generate/openapi';

import { NotFoundPageComponent } from './core/pages/notFound/not-found-page.component';

import { environment } from '../environments/environment';

import { HomeModule } from './features/home/home.module';
import { WelcomeModule } from './features/welcome/welcome.module';
import { SharedModule } from './shared/shared.module';
import { EmpleadosModule } from './features/empleados/empleados.module';
import { MessageService } from 'primeng/api';

@NgModule({
  declarations: [AppComponent, NotFoundPageComponent],
  imports: [
    ApiModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    BrowserModule,
    EmpleadosModule,
    HomeModule,
    HttpClientModule,
    SharedModule,
    WelcomeModule,
  ],
  providers: [{ provide: BASE_PATH, useValue: environment.apiBasePath }, MessageService],
  bootstrap: [AppComponent],
})
export class AppModule {}
