import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormTaskComponent } from './form-task/form-task.component';
import { ListTaskComponent } from './list-task/list-task.component';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [FormTaskComponent, ListTaskComponent],
  exports: [
    FormTaskComponent,
    ListTaskComponent
  ]
})
export class TaskModule { }
