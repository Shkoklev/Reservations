import { Component, OnInit } from '@angular/core';
import {UserService} from '../../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;

  constructor(private userService: UserService) { }

  ngOnInit() {
  }

  onLogInClick(){
    console.log(this.username, this.password)
    this.userService.logIn(this.username, this.password)
      .subscribe(a=>a);
  }

}
