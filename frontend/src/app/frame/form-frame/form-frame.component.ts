import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FrameService } from 'src/app/services/Frame.service';
import { Frame } from 'src/models/Frame.model';

@Component({
  selector: 'app-form-frame',
  templateUrl: './form-frame.component.html',
  styleUrls: ['./form-frame.component.css']
})
export class FormFrameComponent implements OnInit {

  frameForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private frameService: FrameService) { }

  ngOnInit(): void {
    this.frameForm = this.formBuilder.group({
      description: ['', Validators.required],
      project: ['', Validators.required]
    });
  }

  public addFrame() {
    let frame: Frame = new Frame();
    frame.description = this.frameForm.get('description').value;
    frame.project = this.frameForm.get('project').value;

    this.frameService.addFrame(frame).subscribe(
      frame => console.log(frame),
      err => console.log(err)
    )
     
  }

}
