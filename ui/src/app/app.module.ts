import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from "./app.component";
import { HomeComponent } from './home/home.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule } from '@angular/material/button';
import { MatTableModule } from '@angular/material/table';
import { GenerateRandomMatchComponent } from './generate-random-match/generate-random-match.component';
import { ViewPlayedMatchesComponent } from './view-played-matches/view-played-matches.component';
import { SearchForPlayedMatchesComponent } from "./search-for-played-matches/search-for-played-matches.component";
import { ViewPremierLeagueStandingsComponent } from './view-premier-league-standings/view-premier-league-standings.component';
import { TableStandingsService} from "./view-premier-league-standings/view-premier-league-standings.service";
import { MatchService } from "./view-played-matches/view-played-matches.service";
import { RandomMatchService } from "./generate-random-match/generate-random-match.service";
import {AppHttpInterceptorService} from "./http-interceptor.service";
import {HTTP_INTERCEPTORS, HttpClientModule, HttpClientXsrfModule} from "@angular/common/http";
import {MatSortModule} from "@angular/material/sort";

@NgModule({

  declarations: [
    AppComponent,
    HomeComponent,
    GenerateRandomMatchComponent,
    ViewPlayedMatchesComponent,
    SearchForPlayedMatchesComponent,
    ViewPremierLeagueStandingsComponent,
  ],

  imports: [
    BrowserModule,
    HttpClientModule,
    HttpClientXsrfModule.withOptions({
      cookieName: 'Csrf-Token',
      headerName: 'Csrf-Token',
    }),
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatTableModule,
    MatSortModule,
  ],

  providers: [
    TableStandingsService,
    {
      multi: true,
      provide: HTTP_INTERCEPTORS,
      useClass: AppHttpInterceptorService
    },
    MatchService,
    {
      multi: true,
      provide: HTTP_INTERCEPTORS,
      useClass: AppHttpInterceptorService
    },
    RandomMatchService,
    {
      multi: true,
      provide: HTTP_INTERCEPTORS,
      useClass: AppHttpInterceptorService
    },
    HomeComponent,{
      multi: true,
      provide: HTTP_INTERCEPTORS,
      useClass: AppHttpInterceptorService
    }
  ],

  bootstrap: [AppComponent]

})

export class AppModule { }
