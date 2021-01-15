import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FrameService } from 'src/app/services/Frame.service';

import { Frame } from 'src/models/Frame.model';

@Component({
  selector: 'app-list-task',
  templateUrl: './list-task.component.html',
  styleUrls: ['./list-task.component.css']
})
export class ListTaskComponent implements OnInit {
  
  public frame: Frame;

  constructor(private activatedRoute: ActivatedRoute, private frameService: FrameService) { }

  ngOnInit() {
   
    this.frameService.findFrameById(this.activatedRoute.snapshot.params['idFrame'])
    .subscribe(
      frame => {
        this.frame = frame; 
        console.log(frame)       
      }
    )
  }

}
