import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CharDetailsComponent } from './char-details.component';

describe('CharDetailsComponent', () => {
  let component: CharDetailsComponent;
  let fixture: ComponentFixture<CharDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CharDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CharDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
