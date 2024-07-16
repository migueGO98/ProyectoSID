import { TestBed } from '@angular/core/testing';

import { ServicioAuth } from './servicio-auth.service';

describe('ServicioAuthService', () => {
  let service: ServicioAuth;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServicioAuth);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
