import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {User} from '../_models';
import {environment} from '../../environments/environment';


@Injectable({providedIn: 'root'})
export class AuthenticationService {
  private currentUserSubject: BehaviorSubject<User>;
  public currentUser: Observable<User>;

  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private http: HttpClient) {
    this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')));
    this.currentUser = this.currentUserSubject.asObservable();
  }

  public get currentUserValue(): User {
    return this.currentUserSubject.value;
  }

  // http://localhost:8090/token?password=test&username=test@mail.com&grant_type=password&scope=read%20write
  login(username: string, password: string) {
    const queryString = '?password=' + password + '&username=' + username + '&grant_type=password&scope=read%20write';

    return this.http.post<any>(`${environment.apiUrl}/user/login`, {
      email: username,
      password
    }, this.httpOptions)
      .pipe(map(user => {
        // login successful if there's a jwt access_token in the response
        if (user && user.token) {
          // store user details and jwt access_token in local storage to keep user logged in between page refreshes
          localStorage.setItem('currentUser', JSON.stringify(user));
          this.currentUserSubject.next(user);
        }

        return user;
      }));
  }

  logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('currentUser');
    this.currentUserSubject.next(null);
  }
}
