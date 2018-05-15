import {Component, Input, OnInit} from '@angular/core';
import {UserService} from '../../services/user.service';
import {Company} from '../../models/Company';
import {Router} from '@angular/router';
import {User} from '../../models/User';
import {ReservationService} from '../../services/reservation.service';
import {Reservation} from '../../models/Reservation';
import { ViewChild, ElementRef} from '@angular/core';



@Component({
  selector: 'app-reservation-form',
  templateUrl: './reservation-form.component.html',
  styleUrls: ['./reservation-form.component.css']
})
export class ReservationFormComponent implements OnInit {

  @ViewChild('closeDialog') closeDialog: ElementRef;
  @Input() company: Company;
  user: User;
  personCount: number;
  description: string;
  date: Date;
  success:boolean = false;


  constructor(private reservationService: ReservationService,
              private userService: UserService,
              private router: Router) {
  }

  ngOnInit() {

  }

  reserve() {
    this.reservationService.reserve(this.description, this.personCount, this.date, this.company)
      .subscribe(res =>{
        this.success = true;
        setTimeout(()=> {
            this.closeDialog.nativeElement.click();
          },
        1500)
      });
  }

}
