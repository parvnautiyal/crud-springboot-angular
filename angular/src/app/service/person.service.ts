import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Person } from '../common/person';

@Injectable({
  providedIn: 'root',
})
export class PersonService {
  baseUrl = 'http://localhost:8080/api/person';

  constructor(private httpClient: HttpClient) {}

  public getPersonList(): Observable<Person[]> {
    return this.httpClient.get<Person[]>(this.baseUrl);
  }

  addPerson(person: Person): Observable<any> {
    const headers = { 'content-type': 'application/json' };
    const body = JSON.stringify(person);
    return this.httpClient.post(this.baseUrl, body, { headers: headers });
  }

  public deletePerson(id: number) {
    let endPoint = '/' + id;
    location.reload();
    return this.httpClient.delete(this.baseUrl + endPoint);
  }
}
