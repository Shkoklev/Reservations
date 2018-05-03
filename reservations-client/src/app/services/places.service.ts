import {Injectable} from '@angular/core';
import {Place} from '../models/Place';
import {Observable} from 'rxjs/Observable';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class PlacesService {

  static apiUrl = '/api/places';

  constructor(private http: HttpClient){
  }

  getPlaces(): Observable<Place[]> {
    return this.http.get<Place[]>(PlacesService.apiUrl);
  }
}
