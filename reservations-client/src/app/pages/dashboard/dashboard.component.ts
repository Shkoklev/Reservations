import { Component, OnInit } from '@angular/core';
import {Owner} from '../../models/Owner';
import {Reservation} from '../../models/Reservation';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor() { }

  companies : String[] = ['Broz', 'Paris', 'Rustikana'];
  owner: String = 'Angel Angelkovski';
  reservations: Reservation[];
  ngOnInit() {
  }

}
