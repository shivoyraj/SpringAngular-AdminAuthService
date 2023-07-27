import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AppRoutingGuard implements CanActivate {

  constructor(private route:Router){}

  canActivate(route: ActivatedRouteSnapshot,state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    let username = sessionStorage.getItem("userName");
    let toRet:boolean = false;
    if(username!=null)
      toRet = true;
    if(toRet)
      return toRet;
    else{
      this.route.navigate(["error"]);
      return toRet;
    }

  }
  
}
