import { Component, OnInit } from '@angular/core';
import {User} from '../../models/User';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  firstName: String;
  lastName: String;
  email: String;
  username: String;
  password: String;

  constructor() { }

  ngOnInit() {
  }

  onSubmit() {
    console.log("hello");
  }
}
