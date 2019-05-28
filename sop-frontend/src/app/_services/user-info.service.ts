import { Injectable } from '@angular/core';
import { User } from '../_models';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({providedIn: 'root'})
export class UserInfoService {

  private httpOptions = {
    headers: new HttpHeaders({
      Authorization: localStorage.getItem('Authorization')
    })
  };

  constructor(private http: HttpClient) {
  }

  ngonInit() {
  }

  getLoggedInUserInfo(): Observable<User> {
    const url = '/api/user/info';
    return this.http.get<User>(url, this.httpOptions);
  }

}
