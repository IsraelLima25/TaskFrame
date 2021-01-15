import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';

import { ListTaskComponent } from './list-task/list-task.component';
import { FormTaskComponent } from './form-task/form-task.component';
import { TaskService } from '../services/Task.service';

@NgModule({
  imports: [
    CommonModule,
    RouterModule,
    ReactiveFormsModule
  ],
  declarations: [FormTaskComponent, ListTaskComponent],
  exports: [
    FormTaskComponent,
    ListTaskComponent,
  ],
  providers:  [
    TaskService
  ]
})
export class TaskModule { }
