import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewPremierLeagueStandingsComponent } from './view-premier-league-standings.component';

describe('ViewPremierLeagueStandingsComponent', () => {
  let component: ViewPremierLeagueStandingsComponent;
  let fixture: ComponentFixture<ViewPremierLeagueStandingsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewPremierLeagueStandingsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewPremierLeagueStandingsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
