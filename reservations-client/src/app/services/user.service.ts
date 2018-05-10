import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from '../models/User';
import 'rxjs/add/operator/map';
import {Observable} from 'rxjs/Observable';
import {Router} from '@angular/router';

@Injectable()
export class UserService {

  static apiUrl = '/api/user/register'
  public isLoggedIn : boolean;


  constructor(private http: HttpClient, private route: Router) {
  }

  saveUser(firstName: string, lastName: string, email: string, username: string, password: string): Observable<boolean> {
    let newUser: User = new User(firstName, lastName, email, username, password);
    this.http.post(UserService.apiUrl, newUser)
      .map(response =>{
        console.log("Successful");
        return true;
      }).catch(err => {
        console.log("Error" + err);
        return Observable.of(false);
    })
    return Observable.of(true);
  }


  public logIn(username: string, password: string):Observable<boolean> {
    let formData: FormData = new FormData();
    formData.append('username',username);
    formData.append('password',password);
    return this.http.post('/api/login',formData)
      .map(response =>{
        this.route.navigate(['/']);
        this.isLoggedIn = true;
        return true;
      }).catch(err => {
        console.log(err);
        return Observable.of(false);
      })

  }

}
