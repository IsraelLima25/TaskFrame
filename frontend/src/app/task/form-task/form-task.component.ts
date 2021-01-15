import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { TaskService } from 'src/app/services/Task.service';
import { Task } from 'src/models/Task.model';

@Component({
  selector: 'app-form-task',
  templateUrl: './form-task.component.html',
  styleUrls: ['./form-task.component.css']
})
export class FormTaskComponent implements OnInit {

  idFrame: number;
  taskForm: FormGroup;

  constructor(private activatedRoute: ActivatedRoute, private formBuilder: FormBuilder,
    private taskService: TaskService, private toastr: ToastrService) { }

  ngOnInit() {
    this.idFrame = this.activatedRoute.snapshot.params['idFrame'];  

    this.taskForm = this.formBuilder.group({
      title: ['', Validators.required],
      description: ['', Validators.required],
      deliveryDate: ['', Validators.required]
    });  
  }
  
  public addTask() {
    let task: Task = new Task();
    task.title = this.taskForm.get('title').value;
    task.description = this.taskForm.get('description').value;
    task.deliveryDate = this.taskForm.get('deliveryDate').value;

    this.taskService.addTask(task, this.idFrame).subscribe(
      task => {this.toastr.success('Sucesso','Tarefa criada com sucesso')
               this.taskForm.reset()},
      err => {
        this.toastr.error('erro', 'API indisponível'),
        console.log(err);
      }
    )
    
  }
 
}
