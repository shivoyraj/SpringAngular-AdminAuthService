import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { user } from '../user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  public loginUser(user:user):Observable<any>{
    return this.http.get<any>("http://localhost:8081/admin/login/"+user.userName+"/"+user.password)
  }

}
