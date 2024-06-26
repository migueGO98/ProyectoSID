import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { HomeModule } from './features/home/home.module';
import { ApiModule } from './generate/openapi';

import { HttpClientModule } from '@angular/common/http';
import { NewEmpleadoModule } from './features/crearNewEmpleado/new-empleado.module';
import { NotFoundPageComponent } from './core/pages/notFound/not-found-page.component';
import { AuthModule } from '@auth0/auth0-angular';
import { environment } from './environments/environment.development';

@NgModule({
  declarations: [AppComponent, NotFoundPageComponent],
  imports: [
    ApiModule,
    AppRoutingModule,
    AuthModule.forRoot({ ...environment.auth }),
    BrowserAnimationsModule,
    BrowserModule,
    HomeModule,
    HttpClientModule,
    NewEmpleadoModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
