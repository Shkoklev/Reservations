import { Component, OnInit } from '@angular/core';
import {User} from '../../models/User';
import {UserService} from '../../services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class UserComponent implements OnInit {

  firstName: String;
  lastName: String;
  email: String;
  username: String;
  password: String;
  user: User;

  constructor(private userService:UserService) { }

  ngOnInit() {
  }

  onSubmit(){
    this.user = new User(this.firstName, this.lastName, this.email, this.username, this.password);
    console.log("I'm going to call saveUser");
    this.userService.saveUser(this.user);

  }
}
