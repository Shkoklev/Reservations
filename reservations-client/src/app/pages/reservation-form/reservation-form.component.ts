import {Component, Input, OnInit} from '@angular/core';
import {UserService} from '../../services/user.service';
import {Company} from '../../models/Company';
import {Router} from '@angular/router';
import {User} from '../../models/User';

@Component({
  selector: 'app-reservation-form',
  templateUrl: './reservation-form.component.html',
  styleUrls: ['./reservation-form.component.css']
})
export class ReservationFormComponent implements OnInit {

  @Input() company: Company;
  user: User;

  constructor(private userService: UserService, private router: Router) {

  }

  ngOnInit() {

  }

  reserve() {

  }

}
