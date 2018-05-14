import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {CompanyService} from '../../services/company.service';
import {Company} from '../../models/Company';

@Component({
  selector: 'app-company-details',
  templateUrl: './company-details.component.html',
  styleUrls: ['./company-details.component.css']
})
export class CompanyDetailsComponent implements OnInit {

  company: Company;

  constructor(private route: ActivatedRoute, private companyService: CompanyService) { }

  ngOnInit() {
     this.route.params.subscribe(params => {
       let name=params['name'];
       this.companyService.getCompanyByName(name)
         .subscribe(response=>this.company=response);
     });
  }



}
