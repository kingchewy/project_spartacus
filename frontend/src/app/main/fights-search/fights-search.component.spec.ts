import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FightsSearchComponent } from './fights-search.component';

describe('FightsSearchComponent', () => {
  let component: FightsSearchComponent;
  let fixture: ComponentFixture<FightsSearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FightsSearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FightsSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
