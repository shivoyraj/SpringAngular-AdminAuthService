import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppRoutingGuard } from './app-routing-guard';
import { AuthorisationErrorComponent } from './authorisation-error/authorisation-error.component';
import { LoginComponent } from './login/login.component';
import { LoginsuccessComponent } from './loginsuccess/loginsuccess.component';
import { RegistrationComponent } from './registration/registration.component';

const routes: Routes = [

  {path: "", component: LoginComponent},
  {path: 'error', component: AuthorisationErrorComponent },
  {path: "loginsuccess", component: LoginsuccessComponent, canActivate: [AppRoutingGuard]},
  {path: "registration", component: RegistrationComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
