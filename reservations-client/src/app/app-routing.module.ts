import { NgModule } from '@angular/core';
import {Route, RouterModule} from '@angular/router';
import {AdminComponent} from './pages/admin/admin.component';

const routes: Route[] = [
  { path: 'admin', component: AdminComponent }
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
