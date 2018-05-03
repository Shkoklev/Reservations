import {Place} from './Place';
import {CompanyType} from './CompanyType';

export class Company {
  id: number;
  name: string;
  address: string;
  description: string;
  capacity: number;
  place: Place;
  companyType: CompanyType;
  images = [];


  constructor(name: string, address: string, description: string, capacity: number, place: Place, companyType: CompanyType) {
    this.name = name;
    this.address = address;
    this.description = description;
    this.capacity = capacity;
    this.place = place;
    this.companyType = companyType;
  }
}
