import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Frame } from 'src/models/Frame.model';

@Component({
  selector: 'app-frame',
  templateUrl: './frame.component.html',
  styleUrls: ['./frame.component.css']
})
export class FrameComponent implements OnInit {

  @Input() frame: Frame;

  constructor(private router: Router) { }

  ngOnInit() {
    
  }

  addTask(idFrame: number){
    this.router.navigate([`task/add/${idFrame}`]);
  }

}
