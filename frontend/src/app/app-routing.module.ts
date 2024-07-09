import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './features/home/pages/home-page/home-page.component';
import { NotFoundPageComponent } from './core/pages/notFound/not-found-page.component';
import { NewEmpleadoPageComponent } from './features/crearNewEmpleado/pages/new-empleado-page/new-empleado-page.component';
import { LogoutComponent } from './features/home/logout/logout.component';
import { MenuBarComponent } from './shared/component/menu-bar/menu-bar.component';

const routes: Routes = [
  {
    path: '',
    component: MenuBarComponent,
    children: [
      { path: 'home', component: HomePageComponent },
      { path: 'crear-empleado', component: NewEmpleadoPageComponent },
    ],
  },
  {
    path: 'logout',
    component: LogoutComponent,
  },
  // Página no encontrada
  {
    path: '**',
    pathMatch: 'full',
    component: NotFoundPageComponent,
  },
  {
    path: '**',
    redirectTo: '',
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
