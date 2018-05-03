import { Injectable } from '@angular/core';
import {Place} from '../models/Place';
import {Observable} from 'rxjs/Observable';
import {CompanyType} from '../models/CompanyType';
import {of} from 'rxjs/observable/of';

@Injectable()
export class CompanyTypesService {

  private types: CompanyType[] = [
    {id: 1, name: 'Restaurants'},
    {id: 2, name: 'Bars'},
    {id: 3, name: 'Clubs'}
  ];

  getCompanyTypes(): Observable<CompanyType[]> {
    return of(this.types);
  }

}
