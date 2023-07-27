import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { user } from '../user';
import { LoginService } from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user = new user();
  message = '';
  constructor(private service: LoginService, private router: Router) { }

  ngOnInit(): void {
  }

  loginUser() {

    this.service.loginUser(this.user).subscribe(

      data => {

        this.user = data
        sessionStorage.setItem("userName", this.user.userName);
        this.router.navigate(['/loginsuccess'])

      },

      error => {
        console.log(error.error.errorMessage);
         this.message = error.error.errorMessage;
      }
    )

  }

  gotoregistration() {

    console.log("hi hello"), 
    this.router.navigate(['/registration'])

  }

}
