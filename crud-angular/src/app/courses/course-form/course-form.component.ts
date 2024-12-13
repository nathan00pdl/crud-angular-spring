import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AppMaterialModule } from '../../shared/app-material/app-material-module';
import { CoursesService } from '../services/courses.service';

@Component({
  selector: 'app-course-form',
  standalone: true,
  imports: [AppMaterialModule],
  templateUrl: './course-form.component.html',
  styleUrls: ['./course-form.component.scss'],
})
export class CourseFormComponent implements OnInit {
  form: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private service: CoursesService,
    private snackBar: MatSnackBar
  ) {
    this.form = this.formBuilder.group({
      name: [null],
      category: [null],
    });
  }

  ngOnInit(): void {}

  onSubimt() {
    this.service.save(this.form.value).subscribe(
      (result) => console.log(result),
      (error) => this.onError()
    );
  }

  onCancel() {}

  private onError() {
    this.snackBar.open('Erro ao salvar curso.', '', { duration: 5000 });
  }
}