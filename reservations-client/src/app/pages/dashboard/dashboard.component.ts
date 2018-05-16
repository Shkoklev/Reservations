import {Component, OnInit} from '@angular/core';
import {Owner} from '../../models/Owner';
import { Reservation} from '../../models/Reservation';
import {OwnerService} from '../../services/owner.service';
import {Router} from '@angular/router';
import {CompanyService} from '../../services/company.service';
import {Company} from '../../models/Company';
import {ReservationService} from '../../services/reservation.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private ownerService: OwnerService,
              private router: Router,
              private companyService: CompanyService,
              private reservationService: ReservationService) {
  }

  companies: Company[] = [];
  owner: Owner;
  reservations: Reservation[] = [];
  selectedIndexCompany = 0;
  date;
  total = 0;


  ngOnInit() {
    this.ownerService.getLoggedOwner()
      .catch(err => {
        this.router.navigate(['/login/owner']);
        return [];
      })
      .subscribe(own => this.owner = own);

    this.companyService.getCompaniesByOwner()
      .catch(err => {
        return [];
      })
      .subscribe(com => this.companies = com);
  }

  companyClick(selected: number) {
    this.selectedIndexCompany = selected;
    this.loadReservations();
  }

  loadReservations(){
    if(this.date){
      this.reservationService.companyReservationsByDate(this.companies[this.selectedIndexCompany].id, this.date)
        .subscribe(res => {
          this.reservations = res;
          this.total = this.calculatePersonCount();
        });
    }
    else this.reservationService.companyReservations(this.companies[this.selectedIndexCompany].id)
      .subscribe(res=> {
        this.reservations=res
        this.total = this.calculatePersonCount();

      });
  }

  calculatePersonCount():number{
    let total = 0;
    console.log(this.date);
    console.log(this.selectedIndexCompany);
    if(this.date && (this.selectedIndexCompany || this.selectedIndexCompany==0)){
      console.log("inside");
      this.reservations
        .forEach(obj=>{
          total=total+obj.personCount;
      });
    }
    return total;
  }
  logoutUser() {
    this.ownerService.logoutUser().subscribe(res=> {
      this.router.navigate(['home']);
    });

  }
}
