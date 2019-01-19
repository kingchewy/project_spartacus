import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FightsUpcomingComponent } from './fights-upcoming.component';

describe('FightsUpcomingComponent', () => {
  let component: FightsUpcomingComponent;
  let fixture: ComponentFixture<FightsUpcomingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FightsUpcomingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FightsUpcomingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
