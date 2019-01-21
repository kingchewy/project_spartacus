import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FightsHistoryComponent } from './fights-history.component';

describe('FightsHistoryComponent', () => {
  let component: FightsHistoryComponent;
  let fixture: ComponentFixture<FightsHistoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FightsHistoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FightsHistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
