import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CharPickerDetailsComponent } from './char-picker-details.component';

describe('CharPickerDetailsComponent', () => {
  let component: CharPickerDetailsComponent;
  let fixture: ComponentFixture<CharPickerDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CharPickerDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CharPickerDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
