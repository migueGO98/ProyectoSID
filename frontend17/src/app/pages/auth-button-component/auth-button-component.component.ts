import { Component } from '@angular/core';
import { AuthService } from '@auth0/auth0-angular';

@Component({
  selector: 'app-auth-button-component',
  standalone: true,
  imports: [],
  template: `<button (click)="auth.loginWithRedirect()">Log in</button>`,
  exportAs: 'appAuthButtonComponent'
})
export class AuthButtonComponentComponent {
  constructor(public auth: AuthService) {}
}
