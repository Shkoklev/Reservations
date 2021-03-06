import {Component, OnInit} from '@angular/core';
import {PlacesService} from '../../services/places.service';
import {Observable} from 'rxjs/Observable';
import {Place} from '../../models/Place';
import {CompanyTypesService} from '../../services/company-types.service';
import {CompanyType} from '../../models/CompanyType';
import {CompanyService} from '../../services/company.service';
import {CompanyImage} from '../../models/CompanyImage';
import {routes} from '../../app-routing.module';
import {Router} from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  name = '';
  address = '';
  description = '';
  capacity = 0;
  places: Place[];
  selectedPlaceIndex = 0;
  companyTypes: CompanyType[];
  selectedCompanyTypeIndex = 0;
  daysSelected = [false, false, false, false, false, false, false];
  currentUrl = '';
  images: CompanyImage[] = [];
  success: boolean = false;
  notSuccess: boolean = false;

  constructor(private placesService: PlacesService,
              private companyTypesService: CompanyTypesService,
              private companyService: CompanyService,
              private route: Router) {
  }

  ngOnInit() {
    this.placesService.getPlaces()
      .subscribe(places => this.places = places);
    this.companyTypesService.getCompanyTypes()
      .subscribe(types => this.companyTypes = types);
  }

  onAddImageUrl() {
    let image = new CompanyImage(this.currentUrl);
    this.images.push(image);
    this.currentUrl = '';
  }

  onSubmit() {
    let workingDaysMask = this.daysSelected.map(day => {
      if (day)
        return '1';
      else return '0';
    }).join('');

    this.companyService.saveCompany(this.name, this.address, this.description, this.capacity,
      this.places[this.selectedPlaceIndex], this.companyTypes[this.selectedCompanyTypeIndex], this.images, workingDaysMask)
      .catch(err => {
        this.notSuccess = true;
        setTimeout(this.notSuccess = false, 2000);
        return err;
      })
      .subscribe(res => {
        this.success = true;
        setTimeout(this.success = false, 1000);
        this.route.navigateByUrl('/dashboard');
      });
  }

}
