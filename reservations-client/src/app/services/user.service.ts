import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from '../models/User';
import 'rxjs/add/operator/map';
import {Observable} from 'rxjs/Observable';
import {Router} from '@angular/router';
import {map} from 'rxjs/operator/map';
import {Owner} from '../models/Owner';
import {catchError} from 'rxjs/operators';
import {of} from 'rxjs/observable/of';

@Injectable()
export class UserService {

  static apiUrl = '/api/user/register';
  public isLoggedIn: boolean;


  constructor(private http: HttpClient, private router: Router) {
  }

  saveUser(user : User): Observable<boolean>{
    return this.http.post<User>(UserService.apiUrl, user)
      .map(res => true)
      .catch(err => Observable.of(false));
  }


  public logIn(email: string, password: string): Observable<boolean> {
    let formData: FormData = new FormData();
    formData.append('email', email);
    formData.append('password', password);
    return this.http.post('/api/login', formData)
      .map(response => {
        this.isLoggedIn = true;
        return true;
      }).catch(err => {
        console.log(err);
        return Observable.of(false);
      });
  }

  registerOwener(owner: Owner){
    return this.http.post<User>('/api/owner/register', owner)
      .map(res => true)
      .catch(err => Observable.of(false));
  }
  logInOwner(email: string, password: string){
    let formData: FormData = new FormData();
    formData.append('email', email);
    formData.append('password', password);
    return this.http.post('/api/admin/login', formData)
      .map(response => {
        this.isLoggedIn = true;
        return true;
      }).catch(err => {
        console.log(err);
        return Observable.of(false);
      });
  }

  getLoggedUser(): Observable<User> {
    return this.http.get<User>('/api/user/loggedUser');
  }

  logoutUser() {
    this.http.get('/api/logout');
  }

}
