import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { NotFoundComponent } from "./errors/not-found/not-found.component";
import { FormFrameComponent } from "./frame/form-frame/form-frame.component";
import { ListFrameComponent } from "./frame/list-frame/list-frame.component";
import { HomeComponent } from "./home/home.component";
import { FormTaskComponent } from "./task/form-task/form-task.component";
import { ListTaskComponent } from "./task/list-task/list-task.component";

const routes: Routes = [
    { path: '', component: HomeComponent},
    { path: 'frame/add', component: FormFrameComponent },
    { path: 'frame/list', component: ListFrameComponent },
    { path: 'task/add/:idFrame', component: FormTaskComponent },
    { path: 'frame/detail/:idFrame', component: ListTaskComponent },   
    { path: '**', component: NotFoundComponent}
]

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule{}
