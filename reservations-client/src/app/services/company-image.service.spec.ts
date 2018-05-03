import { TestBed, inject } from '@angular/core/testing';

import { CompanyImageService } from './company-image.service';

describe('CompanyImageService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CompanyImageService]
    });
  });

  it('should be created', inject([CompanyImageService], (service: CompanyImageService) => {
    expect(service).toBeTruthy();
  }));
});
