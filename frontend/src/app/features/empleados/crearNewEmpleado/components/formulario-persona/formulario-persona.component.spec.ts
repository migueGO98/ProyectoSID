import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormularioPersonaComponent } from './formulario-persona.component';

describe('FormularioPersonaComponent', () => {
  let component: FormularioPersonaComponent;
  let fixture: ComponentFixture<FormularioPersonaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FormularioPersonaComponent],
    });
    fixture = TestBed.createComponent(FormularioPersonaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
