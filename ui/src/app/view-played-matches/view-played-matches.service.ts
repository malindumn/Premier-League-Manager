import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class MatchService {
  private listMatchesUrl = '/api/listMatches';

  constructor(private http: HttpClient) {
  }

  public getListOfMatches(): any{
    console.log(this.http.get(this.listMatchesUrl))
    return this.http.get(this.listMatchesUrl)
  }

}
