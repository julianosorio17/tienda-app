import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductoCreateUpdateComponent } from './producto-create-update.component';

describe('ProductoCreateUpdateComponent', () => {
  let component: ProductoCreateUpdateComponent;
  let fixture: ComponentFixture<ProductoCreateUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProductoCreateUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductoCreateUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
