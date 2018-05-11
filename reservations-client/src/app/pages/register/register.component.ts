import {Component, OnInit} from '@angular/core';
import {User} from '../../models/User';
import {UserService} from '../../services/user.service';
import {Router} from '@angular/router';
import {map} from 'rxjs/operator/map';
import {Observable} from 'rxjs/Observable';
import {validate} from 'codelyzer/walkerFactory/walkerFn';

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
  confirmPassword: string;
  user: User;


  usernameLabel: string = '';
  passwordLengthValid: string = '';
  passwordValid: string = '';


  valid: boolean = true;

  constructor(private userService: UserService, private route: Router) {
  }

  ngOnInit() {
  }

  onSubmit() {


    if (this.validate()) {
      this.user = new User(this.firstName, this.lastName, this.email, this.username, this.password);
      this.userService.saveUser(this.user)
        .subscribe(res => {
          console.log(res);
          this.route.navigateByUrl('/home');
        });
    }
  }

  validate(): boolean {
    this.valid = true;
    this.usernameLabel = '';
    this.passwordLengthValid = '';
    this.passwordValid = '';

    if (this.password != this.confirmPassword) {
      this.passwordValid = 'Password does not match';
      this.valid = false;
    }
    if (this.password.length <= 3) {
      this.passwordLengthValid = 'Password length should be at least 5 char';
      this.valid = false;
    }
    if (this.username.length <= 3) {
      this.usernameLabel = 'Username should be at least 3 char';
      this.valid = false;
    }
    return this.valid;
  }


}


