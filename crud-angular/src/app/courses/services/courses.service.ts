import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Course } from '../model/course';
import { delay, first, take, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CoursesService {

  private readonly API = '/crud-angular/public/courses.json'

  //Dependency Injection
  constructor(private httpClient: HttpClient) {

  }

  list() {
    return this.httpClient.get<Course[]>(this.API)
    .pipe(
      first(),
      delay(5000),
      tap(courses => console.log(courses))
    );
  }
}
