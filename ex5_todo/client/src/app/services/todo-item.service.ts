import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { environment } from 'src/environments/environment';

const httpOptions = {
  headers: new HttpHeaders(
    {'Content-Type': 'application/json' }
  )
};

const url = environment.url;

@Injectable({
  providedIn: 'root'
})
export class TodoItemService {

  constructor(private client: HttpClient) { }

  public getAll(query: string = '') : Observable<TodoItem[]> {
    let params = new HttpParams().set('query', query);
    return this.client.get<TodoItem[]>(`${url}/todo/`, { params : params });
  }

  public getById(id: number) : Observable<TodoItem> {
    return this.client.get<TodoItem>(`${url}/todo/${id}`);
  }

  public save(item: TodoItem) : Observable<TodoItem> {
    return this.client.post<TodoItem>(`${url}/todo/`, item);
  }

  public update(todoItem: TodoItem) : Observable<TodoItem> {
    return this.client.put<TodoItem>(`${url}/todo/${todoItem.id}`, todoItem);
  }

  public delete(todoItem: TodoItem) : Observable<TodoItem> {
    return this.client.delete<TodoItem>(`${url}/todo/${todoItem.id}`);
  }
}
