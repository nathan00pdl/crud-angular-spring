import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Course } from '../model/course';
import { AppMaterialModule } from '../shared-app-material/app-material-module';
import { CoursesService } from '../services/courses.service';

@Component({
  selector: 'app-courses',
  standalone: true,
  imports: [CommonModule, AppMaterialModule],
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss']

})

export class CoursesComponent {
  courses: Course[] = [];

  displayedColumns = ['name', 'category'];

  coursesService: CoursesService;

  constructor() {
    this.coursesService = new CoursesService();
    this.courses = this.coursesService.list();
  }
}
