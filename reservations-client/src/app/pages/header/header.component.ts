import { Component, OnInit } from '@angular/core';
import {CompanyType} from '../../models/CompanyType';
import {CompanyTypesService} from '../../services/company-types.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  companyTypes: CompanyType[];

  constructor(private companyTypesService: CompanyTypesService) { }

  ngOnInit() {
    this.companyTypesService.getCompanyTypes()
      .subscribe(types => this.companyTypes = types);
  }

}
