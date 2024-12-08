import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Course } from '../model/course';
import { AppMaterialModule } from '../../shared/app-material/app-material-module';
import { CoursesService } from '../services/courses.service';
import { catchError, Observable, of } from 'rxjs';
import { ErrorDialogComponent } from '../../shared/components/error-dialog/error-dialog.component';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-courses',
  standalone: true,
  imports: [CommonModule, AppMaterialModule],
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss']

})

export class CoursesComponent implements OnInit{
  courses$: Observable<Course[]>;

  displayedColumns = ['name', 'category'];

  constructor(
    private coursesService: CoursesService,
    public dialog: MatDialog
  ) {
    this.courses$ = this.coursesService.list()
    .pipe(
      catchError(error => {
        this.onError('Erro ao carregar os cursos.')
        return of([]);
      })
    );
  }

  onError(errorMsg: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMsg
    });
  }

  ngOnInit(): void {}
}
