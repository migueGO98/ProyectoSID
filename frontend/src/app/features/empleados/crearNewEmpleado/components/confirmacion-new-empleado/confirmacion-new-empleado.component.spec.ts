import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfirmacionNewEmpleadoComponent } from './confirmacion-new-empleado.component';

describe('ConfirmacionNewEmpleadoComponent', () => {
  let component: ConfirmacionNewEmpleadoComponent;
  let fixture: ComponentFixture<ConfirmacionNewEmpleadoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ConfirmacionNewEmpleadoComponent],
    });
    fixture = TestBed.createComponent(ConfirmacionNewEmpleadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
