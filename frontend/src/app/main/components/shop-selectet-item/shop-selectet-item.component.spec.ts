import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShopSelectetItemComponent } from './shop-selectet-item.component';

describe('ShopSelectetItemComponent', () => {
  let component: ShopSelectetItemComponent;
  let fixture: ComponentFixture<ShopSelectetItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShopSelectetItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShopSelectetItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
