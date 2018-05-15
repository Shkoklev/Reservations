import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {UserService} from '../../services/user.service';
import {OwnerService} from '../../services/owner.service';

@Component({
  selector: 'app-ownerlogin',
  templateUrl: './ownerlogin.component.html',
  styleUrls: ['./ownerlogin.component.css']
})
export class OwnerloginComponent implements OnInit {

  constructor(private ownerService: OwnerService, private router: Router) { }
  username: string;
  password: string;
  labelText:string = "";
  ngOnInit() {
  }

  onLogInClick() {
    this.ownerService.logInOwner(this.username, this.password)
      .subscribe(res =>{
        if(res === false){
          this.labelText = "Bad Credentials";
        }else {
          this.router.navigate(['/dashboard']);
        }
      });
  }

}
