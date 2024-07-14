import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormularioDomicilioComponent } from './formulario-domicilio.component';

describe('FormularioDomicilioComponent', () => {
  let component: FormularioDomicilioComponent;
  let fixture: ComponentFixture<FormularioDomicilioComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FormularioDomicilioComponent],
    });
    fixture = TestBed.createComponent(FormularioDomicilioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
