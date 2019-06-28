import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ToDoService {
  urls: any = {
    getTodos: 'todo/getall',
    addTodo: 'todo/save',
    deleteTodo: 'todo/delete'
  };
  constructor(private _http: HttpClient) {

  }

  loadData(): Observable<any> {
    return this._http.get(environment.api + this.urls.getTodos, {});
  }

  addTodo(data, newDate: string): Observable<any> {
    var obj = {
      "name": data.name,
      "description": data.description,
      "date": newDate
    }
    return this._http.post(environment.api + this.urls.addTodo, obj);
  }
  editTodo(data, editedDate: string): Observable<any> {
    var obj = {
      "id": data.id,
      "name": data.name,
      "description": data.description,
      "date": editedDate
    }
    return this._http.post(environment.api + this.urls.addTodo, obj);
  }
  deleteTodo(ids): Observable<any> {
    var obj = {
      "todoIds": ids
    }
    return this._http.request('delete', environment.api + this.urls.deleteTodo, { body: obj });
  }
}
