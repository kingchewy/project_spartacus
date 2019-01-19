import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogComponent } from './dialog-create.component';

describe('DialogComponent', () => {
  let component: DialogCreateComponent;
  let fixture: ComponentFixture<DialogCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DialogCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
