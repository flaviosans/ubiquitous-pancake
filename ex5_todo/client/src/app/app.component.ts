import { Component, OnInit } from '@angular/core';
import { TodoItemService } from './services/todo-item.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  todoItems: TodoItem[];
  singleTodoItem = <TodoItem>{};
  itemToEdit = <TodoItem>{};

  constructor(private todoItemService: TodoItemService){ }

  ngOnInit(): void {
    this.loadTodoItems();
  }

  public loadTodoItems(): void {
    this.todoItemService.getAll().subscribe(i => {
      this.todoItems = i;
    });
  }

  public save(todoItem:TodoItem) : void {
    this.todoItemService.save(todoItem).subscribe(i => {
      this.todoItems.push(i);
      this.singleTodoItem = <TodoItem>{};
    });
  }

  public edit(todoItem:TodoItem) : void {
    this.itemToEdit = todoItem;
  }

  public update() {
    this.todoItemService.update(this.itemToEdit).subscribe(t => {
      this.itemToEdit = <TodoItem>{};
    });
  }

  public delete() {
    this.todoItemService.delete(this.itemToEdit).subscribe(t => {
      let i = this.todoItems.indexOf(this.itemToEdit);
      this.todoItems.splice(i, 1);
    });
  }

  public markAsDone(todoItem: TodoItem, event): void {
    todoItem.done = event.currentTarget.checked;
    this.todoItemService.update(todoItem).subscribe(i => {
      
    });
  }
}
