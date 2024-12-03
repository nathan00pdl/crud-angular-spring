import { NgModule } from '@angular/core';

import { MatCardModule } from '@angular/material/card';
import { MatTableModule } from '@angular/material/table';
import { MatToolbarModule } from '@angular/material/toolbar';


@NgModule({
  imports: [
    MatTableModule,
    MatCardModule,
    MatToolbarModule,
  ],
  exports: [
    MatTableModule,
    MatCardModule,
    MatToolbarModule,
  ]
})
export class AppMaterialModule { }
