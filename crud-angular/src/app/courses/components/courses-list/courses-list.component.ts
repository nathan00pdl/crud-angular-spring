
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { MatIcon } from '@angular/material/icon';
import { MatTableModule } from '@angular/material/table';
import { CategoryPipe } from "../../../shared/pipes/category.pipe";
import { Course } from '../../model/course';

@Component({
  selector: 'app-courses-list',
  standalone: true,
  imports: [MatTableModule, MatIcon, CategoryPipe],
  templateUrl: './courses-list.component.html',
  styleUrls: ['./courses-list.component.scss'],
})
export class CoursesListComponent implements OnInit {
  @Input() courses: Course[] = [];
  @Output() add = new EventEmitter(false);
  @Output() edit = new EventEmitter(false);
  @Output() remove = new EventEmitter(false);

  readonly displayedColumns = ['name', 'category', 'actions'];

  constructor() {}

  ngOnInit(): void {}

  onAdd() {
    this.add.emit(true);
  }

  onEdit(course: Course) {
    this.edit.emit(course._id)
  }

  onDelete(course: Course) {
    this.remove.emit(course);
  }
}
