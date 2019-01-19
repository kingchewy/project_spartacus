import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GearListBasicComponent } from './gear-list-basic.component';

describe('GearListBasicComponent', () => {
  let component: GearListBasicComponent;
  let fixture: ComponentFixture<GearListBasicComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GearListBasicComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GearListBasicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
