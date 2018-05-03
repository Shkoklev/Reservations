import { Component, OnInit } from '@angular/core';
import {PlacesService} from '../../services/places.service';
import {Observable} from 'rxjs/Observable';
import {Place} from '../../models/Place';
import {CompanyTypesService} from '../../services/company-types.service';
import {CompanyType} from '../../models/CompanyType';
import {CompanyService} from '../../services/company.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  name = '';
  address = '';
  description= '';
  capacity = 0;
  places: Place[];
  selectedPlaceIndex = 0;
  companyTypes: CompanyType[];
  selectedCompanyTypeIndex = 0;

  currentUrl = '';
  images = [];

  constructor(private placesService: PlacesService, private companyTypesService: CompanyTypesService,
              private companyService: CompanyService) { }

  ngOnInit() {
    this.placesService.getPlaces()
      .subscribe(places => this.places = places);
    this.companyTypesService.getCompanyTypes()
      .subscribe(types => this.companyTypes = types);
  }

  onAddImageUrl() {
    this.images.push(this.currentUrl);
    this.currentUrl = '';
  }

  onSubmit() {
    this.companyService.saveCompany(this.name, this.address, this.description, this.capacity,
      this.places[this.selectedPlaceIndex], this.companyTypes[this.selectedCompanyTypeIndex], this.images);
  }

}
