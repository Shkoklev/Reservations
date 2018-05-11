import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {UserService} from '../../services/user.service';

@Component({
  selector: 'app-ownerlogin',
  templateUrl: './ownerlogin.component.html',
  styleUrls: ['./ownerlogin.component.css']
})
export class OwnerloginComponent implements OnInit {

  constructor(private userService: UserService, private router: Router) { }
  username: string;
  password: string;
  labelText:string = "";
  ngOnInit() {
  }

  onLogInClick() {
    this.userService.logIn(this.username, this.password)
      .subscribe(res =>{
        if(res === false){
          this.labelText = "Bad Credentials";
        }else {
          this.router.navigate(['/']);
        }
      });
  }

}