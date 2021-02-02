import { Component } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { HomeComponent } from "../home/home.component";

@Component({
  selector: 'app-search-for-played-matches',
  templateUrl: './search-for-played-matches.component.html',
  styleUrls: ['./search-for-played-matches.component.css']
})

export class SearchForPlayedMatchesComponent {

  displayedColumns: string[] = ["fbClub1Name", "fbClub2Name", "score1", "score2", "points1", "points2", "date"];
  dataSource: MatTableDataSource<MatchHeaders>;

  constructor(private home: HomeComponent) {
    this.home.searchMatch().subscribe((data) => {
      this.dataSource = new MatTableDataSource<MatchHeaders>(data['body'])
    })

  }
}

export interface MatchHeaders {
  fbClub1Name: string;
  fbClub2Name: string;
  score1: number;
  score2: number;
  points1: number;
  points2: number;
  date: String
}

