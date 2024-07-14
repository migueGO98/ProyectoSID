import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MenubarModule } from 'primeng/menubar';
import { ProgressSpinnerModule } from 'primeng/progressspinner';

import { MenuBarComponent } from './component/menu-bar/menu-bar.component';
import { ProgressSpinnerComponent } from './component/progress-spinner/progress-spinner.component';

@NgModule({
  declarations: [MenuBarComponent, ProgressSpinnerComponent],
  imports: [CommonModule, MenubarModule, ProgressSpinnerModule],
  exports: [MenuBarComponent, ProgressSpinnerComponent],
})
export class SharedModule {}
