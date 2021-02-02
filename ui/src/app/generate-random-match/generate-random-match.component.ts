import { Component } from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import { RandomMatchService } from "./generate-random-match.service";

@Component({
  selector: 'app-generate-random-match',
  templateUrl: './generate-random-match.component.html',
  styleUrls: ['./generate-random-match.component.css']
})

export class GenerateRandomMatchComponent {

  displayedColumns: string[] = ["fbClub1Name", "fbClub2Name", "score1", "score2", "points1", "points2", "date"];
  dataSource: MatTableDataSource<MatchHeaders>;

  constructor(private rms: RandomMatchService) {
    this.rms.getRandomMatch().subscribe((data) => {
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

