import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from '../models/User';
import {Observable} from 'rxjs/Observable';
import {Owner} from '../models/Owner';

@Injectable()
export class OwnerService {

  constructor(private http: HttpClient) { }

  registerOwner(owner: Owner){
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

  isLoggedIn(): Observable<Owner>{
    return this.http.get<Owner>('/api/owner/loggedOwner');

  }
}
