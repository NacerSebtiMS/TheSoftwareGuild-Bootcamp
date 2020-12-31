import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExitHomeComponent } from './exit-home.component';

describe('ExitHomeComponent', () => {
  let component: ExitHomeComponent;
  let fixture: ComponentFixture<ExitHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExitHomeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExitHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
