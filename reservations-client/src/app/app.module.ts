import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {AppRoutingModule} from './app-routing.module';
import { AdminComponent } from './pages/admin/admin.component';
import {PlacesService} from './services/places.service';
import {FormsModule} from '@angular/forms';
import {CompanyTypesService} from './services/company-types.service';
import {HttpClientModule} from '@angular/common/http';
import { CompanyService } from './services/company.service';
import { CompanyImageService } from './services/company-image.service';


@NgModule({
  declarations: [
    AppComponent,
    AdminComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
    PlacesService,
    CompanyTypesService,
    CompanyService,
    CompanyImageService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
