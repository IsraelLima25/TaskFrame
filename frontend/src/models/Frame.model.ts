import { Task } from "./Task.model";

export class Frame{
    id: number;
    description: string;
    project: string;
    tasks: Task [];
}