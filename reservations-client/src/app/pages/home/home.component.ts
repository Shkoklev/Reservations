import { Component, OnInit } from '@angular/core';
import {CompanyService} from '../../services/company.service';
import {Company} from '../../models/Company';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  companies:Company[];
  constructor(private companyService: CompanyService) { }

  ngOnInit() {
    this.companyService.getAllCompanies().subscribe(res => this.companies = res);
  }

}
