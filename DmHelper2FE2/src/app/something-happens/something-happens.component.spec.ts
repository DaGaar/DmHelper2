import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SomethingHappensComponent } from './something-happens.component';

describe('SomethingHappensComponent', () => {
  let component: SomethingHappensComponent;
  let fixture: ComponentFixture<SomethingHappensComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SomethingHappensComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SomethingHappensComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
