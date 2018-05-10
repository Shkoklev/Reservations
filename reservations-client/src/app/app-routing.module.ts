import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AdminComponent} from './pages/admin/admin.component';
import {HeaderComponent} from './pages/header/header.component';
import {HomeComponent} from './pages/home/home.component';
import {CompaniesComponent} from './pages/companies/companies.component';
import {LoginComponent} from './pages/login/login.component';
import {UserComponent} from './pages/register/register.component';

export const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full'},
  { path: 'admin', component: AdminComponent},
  { path: 'home', component: HomeComponent},
  { path: 'companies/:type', component: CompaniesComponent},
  { path: 'companies', component: CompaniesComponent},
  { path: 'login', component: LoginComponent},
  { path: 'register', component: UserComponent }
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
