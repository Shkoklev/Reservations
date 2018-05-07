import { Component, OnInit } from '@angular/core';
import {Company} from '../../models/Company';
import {ActivatedRoute, Params} from '@angular/router';
import {CompanyService} from '../../services/company.service';

@Component({
  selector: 'app-companies',
  templateUrl: './companies.component.html',
  styleUrls: ['./companies.component.css']
})
export class CompaniesComponent implements OnInit {

  companies: Company[];
  typeName: String=null;
  placeName: String=null;

  constructor(private route: ActivatedRoute,private companyService: CompanyService) {
    route.params.subscribe(val => {
      this.typeName=this.route.snapshot.paramMap.get('type');
      this.placeName=this.route.snapshot.paramMap.get('place');
      this.companyService.getCompaniesByType(this.typeName)
        .subscribe(response=>this.companies=response);
    });
  }

  ngOnInit() {
  }


}
