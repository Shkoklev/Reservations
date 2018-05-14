import {Component, Input, OnInit} from '@angular/core';
import {UserService} from '../../services/user.service';
import {Company} from '../../models/Company';
import {Router} from '@angular/router';
import {User} from '../../models/User';
import {ReservationService} from '../../services/reservation.service';


@Component({
  selector: 'app-reservation-form',
  templateUrl: './reservation-form.component.html',
  styleUrls: ['./reservation-form.component.css']
})
export class ReservationFormComponent implements OnInit {
  model: Date;

  @Input() company: Company;
  user: User;
  personCount: number;
  description: string;

  constructor(private reservationService: ReservationService,
              private userService: UserService,
              private router: Router) {

  }

  ngOnInit() {

  }

  reserve() {
    console.log(this.model);
  }

}
