import { ViewPlayedMatchesComponent } from './view-played-matches/view-played-matches.component';
import { ViewPremierLeagueStandingsComponent } from './view-premier-league-standings/view-premier-league-standings.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GenerateRandomMatchComponent } from './generate-random-match/generate-random-match.component';
import { SearchForPlayedMatchesComponent } from "./search-for-played-matches/search-for-played-matches.component";

const routes: Routes = [
  {
    path: 'viewStandings', component: ViewPremierLeagueStandingsComponent
  },
  {
    path: 'viewMatches', component: ViewPlayedMatchesComponent
  },
  {
    path: 'generateRandomMatch', component: GenerateRandomMatchComponent
  },
  {
    path: 'searchMatch', component: SearchForPlayedMatchesComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
