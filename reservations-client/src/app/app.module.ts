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
import { HeaderComponent } from './pages/header/header.component';
import { HomeComponent } from './pages/home/home.component';
import { CompaniesComponent } from './pages/companies/companies.component';
import { LoginComponent } from './pages/login/login.component';
import { UserComponent } from './pages/register/register.component';
import {UserService} from './services/user.service';
import {RouterModule, Routes} from '@angular/router';
import { RegisterowenerComponent } from './pages/registerowener/registerowener.component';
import { OwnerloginComponent } from './pages/ownerlogin/ownerlogin.component';
import { CompanyDetailsComponent } from './pages/company-details/company-details.component';
import { ReservationFormComponent } from './pages/reservation-form/reservation-form.component';
import {OwnerService} from './owner.service';
import { DashboardComponent } from './pages/dashboard/dashboard.component';


@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    HeaderComponent,
    HomeComponent,
    CompaniesComponent,
    LoginComponent,
    UserComponent,
    RegisterowenerComponent,
    OwnerloginComponent,
    CompanyDetailsComponent,
    ReservationFormComponent,
    DashboardComponent
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
    CompanyImageService,
    UserService,
    OwnerService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
