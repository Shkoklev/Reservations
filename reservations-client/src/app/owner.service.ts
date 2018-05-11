import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from './models/User';
import {Owener} from './models/Owner';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class OwnerService {

  constructor(private http: HttpClient) { }

  registerOwner(owner: Owener){
    return this.http.post<User>('/api/owner/register', owner)
      .map(res => true)
      .catch(err => Observable.of(false));
  }
  logInOwner(email: string, password: string){
    let formData: FormData = new FormData();
    formData.append('email', email);
    formData.append('password', password);
    return this.http.post('/api/owner/login', formData)
      .map(response => {
        return true;
      }).catch(err => {
        console.log(err);
        return Observable.of(false);
      });
  }
}
