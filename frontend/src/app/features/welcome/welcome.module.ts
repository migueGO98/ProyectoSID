import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { WelcomePageComponent } from './pages/welcome-page/welcome-page.component';

@NgModule({
  declarations: [WelcomePageComponent],
  imports: [CommonModule],
  exports: [WelcomePageComponent],
})
export class WelcomeModule {}
