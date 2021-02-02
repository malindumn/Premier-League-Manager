import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class RandomMatchService {
  private listMatchesUrl = '/api/randomMatch';

  constructor(private http: HttpClient) {}

  public getRandomMatch(): any{
    console.log(this.http.get(this.listMatchesUrl))
    return this.http.get(this.listMatchesUrl)
  }
}
