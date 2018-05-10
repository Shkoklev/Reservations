import {Component, OnInit} from '@angular/core';
import {CompanyType} from '../../models/CompanyType';
import {CompanyTypesService} from '../../services/company-types.service';
import {PlacesService} from '../../services/places.service';
import {Place} from '../../models/Place';
import {ActivatedRoute} from '@angular/router';

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
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.placesService.getPlaces()
      .subscribe(places => this.places = places);
    this.companyTypesService.getCompanyTypes()
      .subscribe(types => this.companyTypes = types);
  }

  Search() {
    let url;
    if (this.route.toString().indexOf('companies') > 0)
      url = `?place=${this.places[this.selectedPlaceIndex].name}`;
    else
      url = `companies?place=${this.places[this.selectedPlaceIndex].name}`;
  }

}
