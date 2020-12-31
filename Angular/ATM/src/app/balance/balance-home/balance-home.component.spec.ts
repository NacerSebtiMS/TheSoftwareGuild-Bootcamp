import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BalanceHomeComponent } from './balance-home.component';

describe('BalanceHomeComponent', () => {
  let component: BalanceHomeComponent;
  let fixture: ComponentFixture<BalanceHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BalanceHomeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BalanceHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
