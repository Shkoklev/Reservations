import {Component, OnInit} from '@angular/core';
import {CompanyType} from '../../models/CompanyType';
import {CompanyTypesService} from '../../services/company-types.service';
import {PlacesService} from '../../services/places.service';
import {Place} from '../../models/Place';
import {ActivatedRoute, Router} from '@angular/router';
import {UserService} from '../../services/user.service';
import {User} from '../../models/User';
import {OwnerService} from '../../services/owner.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  companyTypes: CompanyType[];
  loggedAsUser: Boolean = false;
  loggedAsOwner: Boolean = false;
  user: User;

  constructor(private companyTypesService: CompanyTypesService, private userService: UserService,
              private router: Router, private ownerService: OwnerService) {
  }

  ngOnInit() {
    this.companyTypesService.getCompanyTypes()
      .subscribe(types => this.companyTypes = types);
    this.userService.getLoggedUser()
      .subscribe(res => {
        this.loggedAsUser=true;
        this.loggedAsOwner=false
        this.user = res;
      },err => {
          this.loggedAsUser = false;
          this.user=null;
      });

    this.ownerService.getLoggedOwner()
      .subscribe(res=>{
        this.loggedAsOwner = true;
        this.loggedAsUser=false
      },err=>{
        this.loggedAsOwner=false;
      })
  }

  logoutUser() {
    this.userService.logoutUser().subscribe(res => {
      this.router.navigate(['home']);
    });

  }
}
