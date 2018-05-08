import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Place} from '../models/Place';
import {CompanyType} from '../models/CompanyType';
import {Company} from '../models/Company';
import {CompanyImageService} from './company-image.service';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class CompanyService {

  static apiUrl = '/api/companies';

  constructor(private http: HttpClient, private imageService: CompanyImageService) { }

  saveCompany(name: string, address: string, description: string, capacity: number,
              place: Place, companyType: CompanyType, imageUrls: string[]) {
    let company = new Company(name, address, description, capacity, place, companyType);
    this.http.post<Company>(CompanyService.apiUrl, company)
      .subscribe(company => this.imageService.saveImages(imageUrls, company))
  }

  getCompaniesByType(type: String): Observable<Company[]> {
      return this.http.get<Company[]>(`${CompanyService.apiUrl}?type=${type}`);
  }

  getCompaniesByPlace(place: String): Observable<Company[]> {
    return this.http.get<Company[]>(`${CompanyService.apiUrl}?place=${place}`);
  }

  getCompaniesByTypeAndPlace(type: String, place: String): Observable<Company[]> {
    return this.http.get<Company[]>(`${CompanyService.apiUrl}?type=${type}&place=${place}`);
  }
  getAllCompanies():Observable<Company[]>{
    return this.http.get<Company[]>(CompanyService.apiUrl);
  }

}
