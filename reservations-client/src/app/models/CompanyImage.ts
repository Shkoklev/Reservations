import {Company} from './Company';

export class CompanyImage {
  id: number;
  imageUrl: string;
  company: Company;

  constructor(imageUrl: string, company: Company) {
    this.imageUrl = imageUrl;
    this.company = company;
  }

}
