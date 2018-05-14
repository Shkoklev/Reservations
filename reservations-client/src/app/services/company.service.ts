import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Place} from '../models/Place';
import {CompanyType} from '../models/CompanyType';
import {Company} from '../models/Company';
import {CompanyImageService} from './company-image.service';
import {Observable} from 'rxjs/Observable';
import {CompanyImage} from '../models/CompanyImage';

@Injectable()
export class CompanyService {

  static apiUrl = '/api/companies';

  constructor(private http: HttpClient, private imageService: CompanyImageService) {
  }

  saveCompany(name: string, address: string, description: string, capacity: number,
              place: Place, companyType: CompanyType, companyImages: CompanyImage[], workingDaysMask: string) {
    let company = new Company(name, address, description, capacity, place, companyType, companyImages, workingDaysMask);
    this.http.post<Company>('/api/owner/add/company', company)
      .subscribe(p => p);
  }

  getCompaniesByType(type: String): Observable<Company[]> {
      return this.http.get<Company[]>(`${CompanyService.apiUrl}?type=${type}`);
  }

  getCompaniesByPlace(place: String): Observable<Company[]> {
    return this.http.get<Company[]>(`${CompanyService.apiUrl}?place=${place}`);
  }

  getCompanyByName(name: String): Observable<Company> {
    return this.http.get<Company>(`${CompanyService.apiUrl}/name/${name}`);
  }

  getCompanyById(id: number): Observable<Company> {
    return this.http.get<Company>(`${CompanyService.apiUrl}/${id}`);
  }

  getAllCompanies(): Observable<Company[]> {
    return this.http.get<Company[]>(CompanyService.apiUrl);
  }
  getCompaniesByOwner() : Observable<Company[]> {
    return this.http.get<Company[]>('/api/owner/companies');
  }

  getCompaniesByQuery(query: String) : Observable<Company[]> {
    return this.http.get<Company[]>(`${CompanyService.apiUrl}?query=${query}`);
  }

}
