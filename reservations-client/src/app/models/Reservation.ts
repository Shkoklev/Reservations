import DateTimeFormat = Intl.DateTimeFormat;
import {User} from './User';
import {Company} from './Company';

export class Reservation {
  remark: String;
  personCount: number;
  date: DateTimeFormat;
  user: User;
  company: Company;


  constructor(remark: String, personCount: number, date: Intl.DateTimeFormat, user: User, company: Company) {
    this.remark = remark;
    this.personCount = personCount;
    this.date = date;
    this.user = user;
    this.company = company;
  }
}
