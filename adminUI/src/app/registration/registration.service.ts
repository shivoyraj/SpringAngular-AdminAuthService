import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { user } from '../user';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private http: HttpClient) { }

  public registerUser(user: user): Observable<any> {
    return this.http.post<any>("http://localhost:8081/admin/register", user)
  }

}
