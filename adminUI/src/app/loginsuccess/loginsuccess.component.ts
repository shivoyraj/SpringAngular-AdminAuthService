import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-loginsuccess',
  templateUrl: './loginsuccess.component.html',
  styleUrls: ['./loginsuccess.component.css']
})
export class LoginsuccessComponent implements OnInit {

  userName:string | null | undefined

  constructor(private router: Router) { }

  logout(){
    sessionStorage.clear();
    this.router.navigate([""])
  }

  ngOnInit(): void {
    this.userName=sessionStorage.getItem("userName")
  }

}
