import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { HomeComponent } from './components/home/home.component';

import { ButtonModule } from 'primeng/button';

@NgModule({
  declarations: [HomeComponent, HomePageComponent],
  imports: [ButtonModule, CommonModule],
  exports: [HomePageComponent],
})
export class HomeModule {}
