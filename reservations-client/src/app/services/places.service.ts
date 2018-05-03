import {Injectable} from '@angular/core';
import {Place} from '../models/Place';
import {Observable} from 'rxjs/Observable';
import {of} from 'rxjs/observable/of';

@Injectable()
export class PlacesService {

  private places: Place[] = [
    {id: 1, name: 'Skopje'},
    {id: 2, name: 'Kocani'},
    {id: 3, name: 'Ohrid'}
  ];

  getPlaces(): Observable<Place[]> {
    return of(this.places);
  }
}
