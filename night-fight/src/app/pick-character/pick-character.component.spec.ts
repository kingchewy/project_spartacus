import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PickCharacterComponent } from './pick-character.component';

describe('PickCharacterComponent', () => {
  let component: PickCharacterComponent;
  let fixture: ComponentFixture<PickCharacterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PickCharacterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PickCharacterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
