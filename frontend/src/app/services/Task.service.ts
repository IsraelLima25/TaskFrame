import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Task } from "src/models/Task.model";

@Injectable()
export class TaskService{

    tasksUrl = 'http://localhost:8080/tasks';

    constructor(private http: HttpClient){}

    addTask(task: Task, idFrame: number){
       return this.http.post<Task>(`${this.tasksUrl}/add/frame/${idFrame}`, task);        
    }

    alterState(idTask: number){
        return this.http.put(`${this.tasksUrl}/alter/task/${idTask}`,null);
    }

    removeTask(idTask: number){
        return this.http.delete(`${this.tasksUrl}/${idTask}`);
    }

}