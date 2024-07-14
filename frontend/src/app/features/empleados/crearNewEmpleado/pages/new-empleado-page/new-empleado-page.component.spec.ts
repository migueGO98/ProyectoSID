import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewEmpleadoPageComponent } from './new-empleado-page.component';

describe('NewEmpleadoPageComponent', () => {
  let component: NewEmpleadoPageComponent;
  let fixture: ComponentFixture<NewEmpleadoPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NewEmpleadoPageComponent],
    });
    fixture = TestBed.createComponent(NewEmpleadoPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
