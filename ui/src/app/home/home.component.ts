import { Component, OnInit } from '@angular/core';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

@Injectable()
export class HomeComponent implements OnInit {

  clicked = false;

  searchedMatchesUrlDate;
  searchedMatchesUrl;
  date;

  constructor(private http: HttpClient) {
    this.searchedMatchesUrl = '/api/searchForMatch/';
  }

  ngOnInit(): void {}

  searchMatch() {
    this.date = (<HTMLInputElement>document.getElementById("inputDate")).value;
    this.searchedMatchesUrlDate = this.searchedMatchesUrl.concat(this.date)
    return this.http.get(this.searchedMatchesUrlDate)
  }

  reset() {
    document.getElementById("inputDate").innerHTML = "";
  }

}
