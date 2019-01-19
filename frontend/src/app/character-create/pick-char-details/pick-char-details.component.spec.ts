import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PickCharDetailsComponent } from './pick-char-details.component';

describe('PickCharDetailsComponent', () => {
  let component: PickCharDetailsComponent;
  let fixture: ComponentFixture<PickCharDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PickCharDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PickCharDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
