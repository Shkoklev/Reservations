import { Component, OnInit } from '@angular/core';
import {Owner} from '../../models/Owner';
import {Reservation} from '../../models/Reservation';
import {OwnerService} from '../../services/owner.service';
import {Router} from '@angular/router';
import {CompanyService} from '../../services/company.service';
import {Company} from '../../models/Company';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private ownerService : OwnerService,
              private router : Router,
              private companyService: CompanyService) { }

  companies : Company[];
  owner: Owner;
  reservations: Reservation[];
  ngOnInit() {
    this.ownerService.isLoggedIn()
      .catch(err => {
        this.router.navigate(['/login/owner']);
        return [];
      })
      .subscribe(own => this.owner=own);

    this.companyService.getCompaniesByOwner()
      .catch(err => {
        this.router.navigate(['/login/owner']);
        return[];
      })
      .subscribe(com => this.companies = com);
  }



}
