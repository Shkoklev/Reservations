import { Component, OnInit } from '@angular/core';
import {User} from '../../models/User';
import {UserService} from '../../services/user.service';
import {ReservationService} from '../../services/reservation.service';
import {Reservation} from '../../models/Reservation';
import {componentRefresh} from '@angular/core/src/render3/instructions';
import {templateJitUrl} from '@angular/compiler';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  user: User;
  reservations: Reservation[] = [];
  success:boolean = false;

  constructor(private userService: UserService,
              private reservationService: ReservationService) { }

  ngOnInit() {
    this.userService.getLoggedUser()
      .subscribe(res=> {
        this.user=res;
        this.reservationService.userReservations(this.user.id)
          .subscribe(res=>this.reservations=res);
      });
  }

  loadReservations(){
    this.reservationService.userReservations(this.user.id)
      .subscribe(res=>this.reservations=res);
  }

  deleteReservation(reservationId: number){
    this.reservationService.deleteReservation(reservationId)
      .subscribe(res=> {
        this.loadReservations();
        this.success = true;
        setTimeout(()=>this.success = false,2000);
        window.location.reload();
      })
  }

}
