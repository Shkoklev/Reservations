import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterowenerComponent } from './register-owner.component';

describe('RegisterowenerComponent', () => {
  let component: RegisterowenerComponent;
  let fixture: ComponentFixture<RegisterowenerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisterowenerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterowenerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
