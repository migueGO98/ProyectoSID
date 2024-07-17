import { Component, inject, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { EmpleadoService } from 'src/app/core/services/empleados/empleado.service';

@Component({
  selector: 'app-new-empleado-page',
  templateUrl: './new-empleado-page.component.html',
  styleUrls: ['./new-empleado-page.component.sass'],
})
export class NewEmpleadoPageComponent implements OnInit, OnDestroy {
  private empleadoService = inject(EmpleadoService);
  public motivosBaja$!: Subscription;

  ngOnInit(): void {
    this.motivosBaja$ = this.empleadoService.recuperarMotivosBaja().subscribe(motivos => {
      motivos.forEach(motivo => console.log(motivo.descripcion));
    });
  }

  // Unsubscribe para evitar fugas de memoria en las suscripciones a observables
  ngOnDestroy(): void {
    this.motivosBaja$.unsubscribe();
  }
}
