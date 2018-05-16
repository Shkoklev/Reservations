import {Component, OnInit} from '@angular/core';
import {CompanyType} from '../../models/CompanyType';
import {CompanyTypesService} from '../../services/company-types.service';
import {PlacesService} from '../../services/places.service';
import {Place} from '../../models/Place';
import {ActivatedRoute, Router} from '@angular/router';
import {UserService} from '../../services/user.service';
import {User} from '../../models/User';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  companyTypes: CompanyType[];
  showLoginButton: Boolean = true;
  user: User;

  constructor(private companyTypesService: CompanyTypesService, private userService: UserService,
              private router: Router) {
  }

  ngOnInit() {
    this.companyTypesService.getCompanyTypes()
      .subscribe(types => this.companyTypes = types);
    this.userService.getLoggedUser()
      .catch(err => {
        this.showLoginButton = true;
        return [];
      })
      .subscribe(res => {
        this.user = res;
        this.showLoginButton = false;
      });
  }

  logoutUser() {
    this.userService.logoutUser().subscribe(res=> {
      this.router.navigate(['home']);
      this.showLoginButton = true;
    });

  }
}
