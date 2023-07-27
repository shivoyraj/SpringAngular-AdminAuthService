import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { user } from '../user';
import { RegistrationService } from './registration.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  user = new user()
  message=''

  constructor(private service:RegistrationService,private router :Router) { }

  ngOnInit(): void {
  }

  registerUser(){
    this.service.registerUser(this.user).subscribe(
      (msg)=>{
        this.message=msg
      },
      error=>{
        this.message=error.error.errorMessage;
      }
    )
  }

}
