import { Component, OnInit } from '@angular/core';
import {UserService} from '../../services/user.service';
import {ActivatedRoute, Router} from '@angular/router';
import 'rxjs/add/operator/catch';
import {Observer} from 'rxjs/Observer';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/observable/of';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;
  labelText:string = "";

  constructor(private userService: UserService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
  }

  onLogInClick() {
    this.userService.logIn(this.username, this.password)
      .subscribe(res =>{
        if(res === false){
          this.labelText = "Bad Credentials";
        }else {
          let url = this.getRedirectUrl();
          this.router.navigate([url]);
        }
      });
  }

  getRedirectUrl() {
    let url;
    this.route.queryParamMap.subscribe(params => url = params.get('redirect'));
    if(url) {
      return url;
    }else {
      return '/';
    }
  }

}
