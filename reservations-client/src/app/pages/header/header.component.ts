import {Component, OnInit} from '@angular/core';
import {CompanyType} from '../../models/CompanyType';
import {CompanyTypesService} from '../../services/company-types.service';
import {PlacesService} from '../../services/places.service';
import {Place} from '../../models/Place';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  companyTypes: CompanyType[];
  selectedPlaceIndex = -1;
  places: Place[];

  constructor(private companyTypesService: CompanyTypesService, private placesService: PlacesService,
              private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.placesService.getPlaces()
      .subscribe(places => this.places = places);
    this.companyTypesService.getCompanyTypes()
      .subscribe(types => this.companyTypes = types);
  }

  Search() {
    if (this.checkIfSelectedPlace() === false)
      return;
    let currentUrl = this.route.toString();
    let url;
    if (currentUrl.indexOf('companies') > 0) {

      url = `${this.router.url}?place=${this.places[this.selectedPlaceIndex].name}`;
    }
    else
      url = `/companies?place=${this.places[this.selectedPlaceIndex].name}`;
    console.log(url);
    this.router.navigateByUrl(url);
  }

  private checkIfSelectedPlace(): Boolean {
      return this.selectedPlaceIndex !== -1;
  }

}
