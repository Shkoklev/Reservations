import {Component, OnInit} from '@angular/core';
import {CompanyService} from '../../services/company.service';
import {Company} from '../../models/Company';
import {Router} from '@angular/router';
import {Subject} from 'rxjs/Subject';
import {Observable} from 'rxjs/Observable';
import {
  debounceTime, distinctUntilChanged, switchMap
} from 'rxjs/operators';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  searchTerms = new Subject<string>();
  companies$: Observable<Company[]>;

  constructor(private router: Router, private companyService: CompanyService) {
  }

  ngOnInit() {
    this.companies$ = this.searchTerms.pipe(
      debounceTime(300),
      distinctUntilChanged(),
      switchMap((query: string) => {
        if (query.length === 0 || query.split(' ').length >= 2)
          return [];
        return this.companyService.getCompaniesByQuery(query);
      }),
    );
  }

  findCompany() {
    //   this.router.navigateByUrl(`/company/${this.companyName}`);
  }

  search(query: string) {
    this.searchTerms.next(query);

  }


}
