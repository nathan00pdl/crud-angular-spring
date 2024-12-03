import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Course } from '../model/course';
import { MatTableModule } from '@angular/material/table';
import { MatCardModule } from '@angular/material/card';
import {MatToolbarModule} from '@angular/material/toolbar';

@Component({
  selector: 'app-courses',
  standalone: true,
  imports: [CommonModule, MatTableModule, MatCardModule, MatToolbarModule],
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss']

})

export class CoursesComponent {
  courses: Course[] = [
    { _id: '1', name: 'Angular', category: 'front-end' }
  ];

  displayedColumns = ['name', 'category'];

  constructor() {}
}
