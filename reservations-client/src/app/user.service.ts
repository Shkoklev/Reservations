import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {User} from './models/User';
import 'rxjs/add/operator/map';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class UserService {

  static apiUrl = '/api/user/register'

  constructor(private http: HttpClient) {
  }

  saveUser(user: User) {
    console.log(user);
    console.log("Now is going to call http.post method")
    this.http.post(UserService.apiUrl, user).subscribe(p=>p);
    console.log("After breakpoint");
  }


  public logIn(username: string, password: string):Observable<User> {
    console.log("In login")
    let params = new HttpParams().set('username', username).set('password', password);
    console.log(params);
    return this.http.post<User>('/api/login', {params: params})
  }

}
