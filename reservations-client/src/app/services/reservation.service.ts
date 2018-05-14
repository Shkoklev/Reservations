import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Reservation} from '../models/Reservation';

@Injectable()
export class ReservationService {

  constructor(private http: HttpClient) { }


  reserve(reservation: Reservation) {
    return this.http.post('/api/reserve', reservation);
  }
}
