import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthentificationHomeComponent } from './authentification-home.component';

describe('AuthentificationHomeComponent', () => {
  let component: AuthentificationHomeComponent;
  let fixture: ComponentFixture<AuthentificationHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AuthentificationHomeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AuthentificationHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
