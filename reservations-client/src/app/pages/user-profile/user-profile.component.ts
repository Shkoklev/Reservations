import { Component, OnInit } from '@angular/core';
import {User} from '../../models/User';
import {UserService} from '../../services/user.service';
import {ReservationService} from '../../services/reservation.service';
import {Reservation} from '../../models/Reservation';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  user: User;
  reservations: Reservation[] = [];

  constructor(private userService: UserService, private reservationService: ReservationService) { }

  ngOnInit() {
    this.userService.getLoggedUser()
      .subscribe(res=> {
        this.user=res;
        this.reservationService.userReservations(this.user.firstName)
          .subscribe(res=>this.reservations=res);
      });

  }

}
