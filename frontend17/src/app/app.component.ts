import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { AuthButtonComponentComponent } from "./pages/auth-button-component/auth-button-component.component";

@Component({
    selector: 'app-root',
    standalone: true,
    templateUrl: './app.component.html',
    styleUrl: './app.component.sass',
    imports: [RouterOutlet, AuthButtonComponentComponent]
})
export class AppComponent {
  title = 'frontend17';
}
