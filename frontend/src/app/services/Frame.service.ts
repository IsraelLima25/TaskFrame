import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Frame } from "src/models/Frame.model";

@Injectable()
export class FrameService{

    framesUrl = 'http://localhost:8080/frames';

    constructor(private http: HttpClient){}

    addFrame(frame: Frame){
       return this.http.post(`${this.framesUrl}`,frame);        
    }
}