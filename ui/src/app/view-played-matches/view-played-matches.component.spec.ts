import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewPlayedMatchesComponent } from './view-played-matches.component';

describe('ViewPlayedMatchesComponent', () => {
  let component: ViewPlayedMatchesComponent;
  let fixture: ComponentFixture<ViewPlayedMatchesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewPlayedMatchesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewPlayedMatchesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
