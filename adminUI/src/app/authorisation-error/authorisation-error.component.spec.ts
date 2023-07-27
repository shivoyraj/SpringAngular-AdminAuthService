import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthorisationErrorComponent } from './authorisation-error.component';

describe('AuthorisationErrorComponent', () => {
  let component: AuthorisationErrorComponent;
  let fixture: ComponentFixture<AuthorisationErrorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AuthorisationErrorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AuthorisationErrorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
