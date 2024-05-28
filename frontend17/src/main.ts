import { bootstrapApplication } from '@angular/platform-browser';
import { provideAuth0 } from '@auth0/auth0-angular';
import { AppComponent } from './app/app.component';


bootstrapApplication(AppComponent, {
  providers: [
    provideAuth0({
      domain: 'agricultura-dgec-dev.us.auth0.com',
      clientId: 'HUwI7ALLh5h2kPPBL5u1gcYEvKhP9fbP',
      authorizationParams: {
        redirect_uri: window.location.origin
      }
    }),
  ]
});
