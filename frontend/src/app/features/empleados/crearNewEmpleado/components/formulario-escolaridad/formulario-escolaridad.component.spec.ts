import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormularioEscolaridadComponent } from './formulario-escolaridad.component';

describe('FormularioEscolaridadComponent', () => {
  let component: FormularioEscolaridadComponent;
  let fixture: ComponentFixture<FormularioEscolaridadComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FormularioEscolaridadComponent],
    });
    fixture = TestBed.createComponent(FormularioEscolaridadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
