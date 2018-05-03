import { Injectable } from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {CompanyType} from '../models/CompanyType';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class CompanyTypesService {

  static apiUrl = '/api/types';

  constructor(private http: HttpClient) {
  }

  getCompanyTypes(): Observable<CompanyType[]> {
    return this.http.get<CompanyType[]>(CompanyTypesService.apiUrl);
  }

}
