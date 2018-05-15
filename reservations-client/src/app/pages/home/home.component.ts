import {Component, OnInit} from '@angular/core';
import {CompanyService} from '../../services/company.service';
import {Company} from '../../models/Company';
import {ActivatedRoute, Router} from '@angular/router';
import {Subject} from 'rxjs/Subject';
import {Observable} from 'rxjs/Observable';
import {
  debounceTime, distinctUntilChanged, switchMap
} from 'rxjs/operators';
import {Place} from '../../models/Place';
import {PlacesService} from '../../services/places.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  searchTerms = new Subject<string>();
  companies$: Observable<Company[]>;
  selectedPlaceIndex = -1;
  places: Place[];

  constructor(private router: Router, private companyService: CompanyService,
              private route: ActivatedRoute, private placesService: PlacesService) {
  }

  ngOnInit() {
    this.placesService.getPlaces()
      .subscribe(places => this.places = places);
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

  search(query: string) {
    this.searchTerms.next(query);

  }

  searchPlace() {
    if(this.selectedPlaceIndex == -1)
    {
      return;
    }
    let url = `/companies?place=${this.places[this.selectedPlaceIndex].name}`;
    this.router.navigateByUrl(url);
  }

}
