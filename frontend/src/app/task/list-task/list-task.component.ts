import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { FrameService } from 'src/app/services/Frame.service';
import { TaskService } from 'src/app/services/Task.service';

import { Frame } from 'src/models/Frame.model';

@Component({
  selector: 'app-list-task',
  templateUrl: './list-task.component.html',
  styleUrls: ['./list-task.component.css']
})
export class ListTaskComponent implements OnInit {

  public frame: Frame;

  constructor(private activatedRoute: ActivatedRoute, private frameService: FrameService,
    private taskService: TaskService, private toastr: ToastrService) { }

  ngOnInit() {
    this.frameService.findFrameById(this.activatedRoute.snapshot.params['idFrame'])
      .subscribe(
        frame => {
          this.frame = frame;
          console.log(frame)
        }
      )
  }

  alterState(idTask: number) {
    this.taskService.alterState(idTask).subscribe(
      response => this.toastr.success('Tarefa alterada com sucesso', 'Sucesso'),
      err => {
        console.log(err);
        this.toastr.error('API indisponível', 'Erro');
      }
    )
  }

  removeTask(idTask: number) {

    this.taskService.removeTask(idTask).subscribe(
      () => {
          this.removeTaskList(idTask);
          this.toastr.success('Tarefa removida do quadro com sucesso','Sucesso');   
       },
       err => {
         console.log(err);
         this.toastr.error('API indisponível');
       }
    )
  }

  removeTaskList(idTask: number){
    this.frame.tasks.forEach((item, index) => {
      if (item.id === idTask) this.frame.tasks.splice(index, 1);
    });
  }

}
