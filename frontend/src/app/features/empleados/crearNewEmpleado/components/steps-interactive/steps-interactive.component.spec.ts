import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StepsInteractiveComponent } from './steps-interactive.component';

describe('StepsInteractiveComponent', () => {
  let component: StepsInteractiveComponent;
  let fixture: ComponentFixture<StepsInteractiveComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [StepsInteractiveComponent],
    });
    fixture = TestBed.createComponent(StepsInteractiveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
