import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { FrameService } from 'src/app/services/Frame.service';
import { Frame } from 'src/models/Frame.model';

@Component({
  selector: 'app-list-frame',
  templateUrl: './list-frame.component.html',
  styleUrls: ['./list-frame.component.css']
})
export class ListFrameComponent implements OnInit {

  frames: Frame [];

  constructor(private serviceFrame: FrameService, private toastr: ToastrService) { }

  ngOnInit() {
    this.serviceFrame.listFrames().subscribe(
      response => {
        this.frames = response
      },
      err => {
        this.toastr.error('Erro', 'API não responde')
        console.log(err);
      }
    )
  }

}
