import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AdminComponent} from './pages/admin/admin.component';
import {HeaderComponent} from './pages/header/header.component';
import {HomeComponent} from './pages/home/home.component';
import {CompaniesComponent} from './pages/companies/companies.component';
import {LoginComponent} from './pages/login/login.component';
import {UserComponent} from './pages/register/register.component';
import {CompanyDetailsComponent} from './pages/company-details/company-details.component';
import {ReservationFormComponent} from './pages/reservation-form/reservation-form.component';
import {OwnerloginComponent} from './pages/ownerlogin/ownerlogin.component';
import {DashboardComponent} from './pages/dashboard/dashboard.component';
import {RegisterOwnerComponent} from './pages/register-owner/register-owner.component';
import {UserProfileComponent} from './pages/user-profile/user-profile.component';

export const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full'},
  { path: 'admin', component: AdminComponent},
  { path: 'home', component: HomeComponent},
  { path: 'companies/:type', component: CompaniesComponent},
  { path: 'companies', component: CompaniesComponent},
  { path: 'login', component: LoginComponent},
  { path: 'register', component: UserComponent },
  { path:  'register/owner', component: RegisterOwnerComponent},
  { path:  'company/:name', component: CompanyDetailsComponent},
  { path: 'login/owner', component: OwnerloginComponent},
  { path: 'dashboard', component: DashboardComponent },
  { path: 'profile', component: UserProfileComponent}
];

@NgModule({
  exports: [
    RouterModule
  ],
  imports: [
    RouterModule.forRoot(routes)
  ]
})
export class AppRoutingModule { }
