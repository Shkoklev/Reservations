import {User} from './User';
import {Company} from './Company';


export class Reservation {
  remark: String;
  personCount: number;
  forDate: any;
  user: User;
  company: Company;


  constructor(remark: String, personCount: number, date: Date,  company: Company) {
    this.remark = remark;
    this.personCount = personCount;
    this.forDate = date;
    this.company = company;
  }
}
