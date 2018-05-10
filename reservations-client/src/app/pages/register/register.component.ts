import { Component, OnInit } from '@angular/core';
import {User} from '../../models/User';
import {UserService} from '../../services/user.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class UserComponent implements OnInit {

  firstName: string;
  lastName: string;
  email: string;
  username: string;
  password: string;
  labelText: string = "";
  constructor(private userService:UserService, private route: Router) { }

  ngOnInit() {
  }

  onSubmit() {
    if (this.username.length >= 3 && this.password.length >= 5) {
      this.userService.saveUser(this.firstName, this.lastName, this.email, this.username, this.password)
        .subscribe((response) => {
          if (response == true) {
            this.route.navigateByUrl('/login');
          }
          else {
            console.log("Greska");

          }
        })
    }
    else {
      this.labelText = "Username mora da bide pogolem od 3, a lozinkata mora da bide pogolema od 5";
    }
  }
}
