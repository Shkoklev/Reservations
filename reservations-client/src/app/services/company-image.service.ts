import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Company} from '../models/Company';
import {Observable} from 'rxjs/Observable';
import {CompanyImage} from '../models/CompanyImage';

@Injectable()
export class CompanyImageService {

  static apiUrl = '/api/images';

  constructor(private http: HttpClient) { }

  saveImages(urls: string[], company: Company): Observable<CompanyImage[]> {
    let images = urls.map(url => new CompanyImage(url, company));
    return this.http.post<CompanyImage[]>(CompanyImageService.apiUrl, images);
  }

}
