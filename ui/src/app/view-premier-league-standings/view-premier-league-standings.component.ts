import {Component, OnInit, ViewChild} from '@angular/core';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
import {TableStandingsService} from "./view-premier-league-standings.service";

@Component({
  selector: 'app-view-premier-league-standings',
  templateUrl: './view-premier-league-standings.component.html',
  styleUrls: ['./view-premier-league-standings.component.css']
})

export class ViewPremierLeagueStandingsComponent implements OnInit{

  displayedColumns: string[] = ['nameOfTheClub', 'location', 'regNo', 'wins', 'draws', 'defeats', 'goalsReceived', 'goalsScored', 'goalDifference', 'points', 'numOfMatchesPlayed'];
  dataSource: MatTableDataSource<StandingsHeaders>;

  constructor(private tss: TableStandingsService) {}

  @ViewChild(MatSort) sort: MatSort;

  ngOnInit(): void {
    this.dataSource = new MatTableDataSource<StandingsHeaders>();

    this.tss.getListOfClubs().subscribe((data) => {
      this.dataSource = new MatTableDataSource<StandingsHeaders>(data['body']);
      this.dataSource.sort = this.sort;
    })
  }
}

export interface StandingsHeaders {
  nameOfTheClub: string;
  location: string;
  regNo: string;
  wins: number;
  draws: number;
  defeats: number;
  goalsReceived: number;
  goalsScored: number;
  goalDifference: number;
  points: number;
  numOfMatchesPlayed: number;
}
