import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { HomeComponent } from './components/home/home.component';

import { ButtonModule } from 'primeng/button';
import { LogoutComponent } from './logout/logout.component';

@NgModule({
  declarations: [HomeComponent, HomePageComponent, LogoutComponent],
  imports: [ButtonModule, CommonModule],
  exports: [HomePageComponent],
})
export class HomeModule {}
