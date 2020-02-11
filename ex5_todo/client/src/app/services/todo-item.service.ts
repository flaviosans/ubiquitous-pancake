import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

const url = "http://localhost:8080";

@Injectable({
  providedIn: 'root'
})
export class TodoItemService {

  constructor(private client: HttpClient) { }

  public getAll() : Observable<TodoItem[]> {
    return this.client.get<TodoItem[]>(`${url}/todo/`);
  }
  public getById(id: number) : Observable<TodoItem> {
    return this.client.get<TodoItem>(`${url}/todo/${id}`);
  } 
}
