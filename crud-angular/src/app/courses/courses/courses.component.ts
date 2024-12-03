import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Course } from '../model/course';
import { AppMaterialModule } from '../shared-app-material/app-material-module';

@Component({
  selector: 'app-courses',
  standalone: true,
  imports: [CommonModule, AppMaterialModule],
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
