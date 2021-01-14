import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormFrameComponent } from './form-frame/form-frame.component';
import { ListFrameComponent } from './list-frame/list-frame.component';
import { FrameComponent } from './frame/frame.component';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [FormFrameComponent, ListFrameComponent, FrameComponent],
  exports: [
    FormFrameComponent,
    ListFrameComponent
  ]
})
export class FrameModule { }
