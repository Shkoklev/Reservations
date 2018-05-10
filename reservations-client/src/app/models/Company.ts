import {Place} from './Place';
import {CompanyType} from './CompanyType';
import {CompanyImage} from './CompanyImage';

export class Company {
  id: number;
  name: string;
  address: string;
  description: string;
  capacity: number;
  place: Place;
  companyType: CompanyType;
  images: CompanyImage[];


  constructor(name: string, address: string, description: string, capacity: number, place: Place, companyType: CompanyType, images: CompanyImage[]) {
    this.name = name;
    this.address = address;
    this.description = description;
    this.capacity = capacity;
    this.place = place;
    this.companyType = companyType;
    this.images = images;
  }

  setImages(images: CompanyImage[]) {
    this.images = images;
  }
}
