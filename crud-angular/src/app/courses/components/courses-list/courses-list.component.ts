import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { AppMaterialModule } from '../../../shared/app-material/app-material-module';
import { Course } from '../../model/course';

@Component({
  selector: 'app-courses-list',
  standalone: true,
  imports: [CommonModule, AppMaterialModule],
  templateUrl: './courses-list.component.html',
  styleUrls: ['./courses-list.component.scss'],
})
export class CoursesListComponent implements OnInit {
  @Input() courses: Course[] = [];
  @Output() add = new EventEmitter(false);

  readonly displayedColumns = ['name', 'category', 'actions'];

  constructor() {}

  ngOnInit(): void {}

  onAdd() {
    this.add.emit(true);
  }
}
