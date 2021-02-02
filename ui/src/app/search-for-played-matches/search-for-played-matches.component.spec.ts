import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchForPlayedMatchesComponent } from './search-for-played-matches.component';

describe('SearchForPlayedMatchesComponent', () => {
  let component: SearchForPlayedMatchesComponent;
  let fixture: ComponentFixture<SearchForPlayedMatchesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchForPlayedMatchesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchForPlayedMatchesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
