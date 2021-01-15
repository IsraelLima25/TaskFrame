import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import { FormFrameComponent } from './form-frame/form-frame.component';
import { ListFrameComponent } from './list-frame/list-frame.component';
import { FrameComponent } from './frame/frame.component';
import { FrameService } from '../services/Frame.service';

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    RouterModule
  ],
  declarations: [
    FormFrameComponent, ListFrameComponent, FrameComponent
  ],
  exports: [
    FormFrameComponent,
    ListFrameComponent
  ],
  providers: [FrameService]
})
export class FrameModule { }
