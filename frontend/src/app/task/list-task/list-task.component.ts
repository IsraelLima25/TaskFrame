import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { FrameService } from 'src/app/services/Frame.service';
import { TaskService } from 'src/app/services/Task.service';
import { FilterTaskDate } from 'src/models/FilterTaskDate.model';

import { Frame } from 'src/models/Frame.model';

@Component({
  selector: 'app-list-task',
  templateUrl: './list-task.component.html',
  styleUrls: ['./list-task.component.css']
})
export class ListTaskComponent implements OnInit {

  public frame: Frame;
  formFilter: FormGroup;

  constructor(private activatedRoute: ActivatedRoute, private frameService: FrameService,
    private taskService: TaskService, private toastr: ToastrService, private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.frameService.findFrameById(this.activatedRoute.snapshot.params['idFrame'])
      .subscribe(
        frame => {
          this.frame = frame;
          console.log(frame)
        }
      )

      this.formFilter = this.formBuilder.group({
        dateStart: ['',Validators.required],
        dateFinish: ['',Validators.required]
      });
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

  filter(){
   let filterForm:FilterTaskDate = new FilterTaskDate();
    filterForm.from = this.formFilter.get('dateStart').value;
    filterForm.to = this.formFilter.get('dateFinish').value;

    this.taskService.filterTask(filterForm).subscribe(
      listTasksFilter => {
        this.frame.tasks = listTasksFilter;
      },
      err => {
        console.log(err),
        this.toastr.error('API indisponível', 'Erro');
      }
    )
  }

}
