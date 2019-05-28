import { NgModule } from '@angular/core';
import {
  MatButtonModule, MatCardModule,
  MatFormFieldModule,
  MatGridListModule,
  MatIconModule,
  MatOptionModule,
  MatSelectModule, MatSnackBarModule,
  MatToolbarModule
} from '@angular/material';



@NgModule({
  imports: [

  ],
  exports: [
    MatGridListModule,
    MatIconModule,
    MatButtonModule ,
    MatFormFieldModule,
    MatToolbarModule,
    MatOptionModule,
    MatSelectModule,
    MatCardModule,
    MatSnackBarModule
  ]
})
export class MaterialModule { }
