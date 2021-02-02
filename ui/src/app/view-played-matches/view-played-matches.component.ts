import { Component } from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import { MatchService } from "./view-played-matches.service";

@Component({
  selector: 'app-view-played-matches',
  templateUrl: './view-played-matches.component.html',
  styleUrls: ['./view-played-matches.component.css']
})

export class ViewPlayedMatchesComponent {

  displayedColumns: string[] = ["fbClub1Name", "fbClub2Name", "score1", "score2", "points1", "points2", "date"];
  dataSource: MatTableDataSource<MatchHeaders>;

  constructor(private ms: MatchService) {
    this.ms.getListOfMatches().subscribe((data) => {
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
