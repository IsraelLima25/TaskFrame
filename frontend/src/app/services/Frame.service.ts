import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Frame } from "src/models/Frame.model";

@Injectable()
export class FrameService{

    framesUrl = 'http://localhost:8080/frames';

    constructor(private http: HttpClient){}

    addFrame(frame: Frame){
       return this.http.post<Frame>(`${this.framesUrl}`,frame);        
    }

    listFrames(){
        return this.http.get<any>(`${this.framesUrl}`);        
    }

    findFrameById(idFrame: number){
        return this.http.get<Frame>(`${this.framesUrl}/${idFrame}`);
    }
}