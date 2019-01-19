import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { XpBarComponent } from './xp-bar.component';

describe('XpBarComponent', () => {
  let component: XpBarComponent;
  let fixture: ComponentFixture<XpBarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ XpBarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(XpBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
