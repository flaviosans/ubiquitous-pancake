import { Component, OnInit } from '@angular/core';
import { TodoItemService } from './services/todo-item.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  todoItems = new Array<TodoItem>();
  constructor(private todoItemService: TodoItemService){ }

  ngOnInit(): void {
    this.todoItemService.getAll().subscribe(t =>{
      this.todoItems = t;
    })
  }
  
}
