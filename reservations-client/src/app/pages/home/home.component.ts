import { Component, OnInit } from '@angular/core';
import {CompanyService} from '../../services/company.service';
import {Company} from '../../models/Company';
import {Router} from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  companyName: String = '';

  constructor(private router: Router) { }

  ngOnInit() {

  }

  findCompany() {
      this.router.navigateByUrl(`/company/${this.companyName}`);
  }


}
