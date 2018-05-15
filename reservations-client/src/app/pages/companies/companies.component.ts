import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {Company} from '../../models/Company';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {CompanyService} from '../../services/company.service';
import {UserService} from '../../services/user.service';
import {catchError} from 'rxjs/operators';
import {tryCatch} from 'rxjs/util/tryCatch';

@Component({
  selector: 'app-companies',
  templateUrl: './companies.component.html',
  styleUrls: ['./companies.component.css']
})
export class CompaniesComponent implements OnInit {

  company: Company;
  companies: Company[];
  typeName: String = null;
  placeName: String = null;

  constructor(private route: ActivatedRoute, private companyService: CompanyService, private userService: UserService, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(val => {
      this.typeName = val['type'];
      if (this.typeName != null) {
        this.companyService.getCompaniesByType(this.typeName)
          .subscribe(response => this.companies = response);
      }
    });
    this.route.queryParams.subscribe(val => {
      this.placeName = val['place'];
      if (this.placeName != null)
        this.companyService.getCompaniesByPlace(this.placeName)
          .subscribe(response => this.companies = response);
    });
  }

  onReserve(company: Company) {
    this.company = company;
  }

}


