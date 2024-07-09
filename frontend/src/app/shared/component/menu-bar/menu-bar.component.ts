import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-menu-bar',
  templateUrl: './menu-bar.component.html',
  styleUrls: ['./menu-bar.component.sass'],
})
export class MenuBarComponent implements OnInit {
  items: MenuItem[] | undefined;

  ngOnInit() {
    this.items = [
      {
        label: 'Empleados',
        icon: 'pi pi-fw pi-user',
        items: [
          {
            label: 'Nuevo empleado',
            icon: 'pi pi-fw pi-user-plus',
          },
          {
            label: 'Dar de baja empleado',
            icon: 'pi pi-fw pi-user-minus',
          },
          {
            label: 'Datos de empleados',
            icon: 'pi pi-fw pi-users',
          },
        ],
      },
    ];
  }
}
