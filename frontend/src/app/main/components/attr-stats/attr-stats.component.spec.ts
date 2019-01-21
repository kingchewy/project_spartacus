import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AttrStatsComponent } from './attr-stats.component';

describe('AttrStatsComponent', () => {
  let component: AttrStatsComponent;
  let fixture: ComponentFixture<AttrStatsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AttrStatsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AttrStatsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
