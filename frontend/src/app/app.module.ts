import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { ApiModule, BASE_PATH, Configuration } from './generate/openapi';

import { NotFoundPageComponent } from './core/pages/notFound/not-found-page.component';

import { environment } from '../environments/environment';

import { HomeModule } from './features/home/home.module';
import { WelcomeModule } from './features/welcome/welcome.module';
import { SharedModule } from './shared/shared.module';
import { EmpleadosModule } from './features/empleados/empleados.module';
import { MessageService } from 'primeng/api';
import { DatePipe } from '@angular/common';
import { ServicioAuth } from './core/services/servicio-auth.service';

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
  providers: [
    { provide: BASE_PATH, useValue: environment.apiBasePath },
    DatePipe,
    MessageService,
    ServicioAuth,
    {
      provide: Configuration,
      useFactory: (authService: ServicioAuth) =>
        new Configuration({
          basePath: environment.apiBasePath,
          accessToken: authService.getAccessToken.bind(authService),
        }),
      deps: [ServicioAuth],
      multi: false,
    },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
