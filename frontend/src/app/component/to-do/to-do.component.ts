import { Component, OnInit, AfterViewInit, OnDestroy, ViewChild } from '@angular/core';
import { ToDoService } from '../../service/to-do.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Subject } from 'rxjs';
import { ToastrService } from 'ngx-toastr';
import { DataTableDirective } from 'angular-datatables';

@Component({
  selector: 'app-to-do',
  templateUrl: './to-do.component.html',
  styleUrls: ['./to-do.component.css']
})
export class ToDoComponent implements OnInit, OnDestroy, AfterViewInit {
  @ViewChild(DataTableDirective, { static: false }) dtElement: DataTableDirective;

  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();

  todos: any = [];

  todoData = {}

  selectedTodo = {
    id: 0,
    name: '',
    description: '',
    date: new Date()
  };

  selectedIndex: 0;
  minDate: Date = new Date();
  selectIds: any = [];

  constructor(
    private _modalService: NgbModal,
    private _todoService: ToDoService,
    private _toastr: ToastrService) {
  }

  ngOnInit() {
    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 10,

    };
    this.loadData();
  }

  ngAfterViewInit() {
    this.dtTrigger.next();
  }

  reRender(): void {
    if (this.dtElement.dtInstance) {
      this.dtElement.dtInstance.then((dtInstance: DataTables.Api) => {
        dtInstance.destroy();
        this.dtTrigger.next();
      });
    }
  }

  loadData() {
    this._todoService.loadData().subscribe(result => {
      if (result.code == 200) {
        this.todos = [...result.data];
        this.todos.forEach(element => {
          element['isSelected'] = false;
        });
        this.reRender();
      }
      else {
        this._toastr.show('Something went wrong', 'Error');
      }
    })
  }

  twoDigits(d) {
    if (0 <= d && d < 10) return "0" + d.toString();
    if (-10 < d && d < 0) return "-0" + (-1 * d).toString();
    return d.toString();
  }

  selectTodo(index) {
    this.todos[index].isSelected = !this.todos[index].isSelected;
  }
  selectAllTodo(event) {
    if (event.target.checked) {
      this.todos.forEach(element => {
        element['isSelected'] = true;
      });
    }
    else {
      this.todos.forEach(element => {
        element['isSelected'] = false;
      });
    }
  }

  addTodo(formPost) {
    if (formPost.valid) {
      let newDate = this.todoData['date'].getFullYear() + "-" + this.twoDigits(1 + this.todoData['date'].getMonth()) + "-" + this.twoDigits(this.todoData['date'].getDate()) + " " + this.twoDigits(this.todoData['date'].getHours()) + ":" + this.twoDigits(this.todoData['date'].getMinutes()) + ":" + this.twoDigits(this.todoData['date'].getSeconds());
      this._todoService.addTodo(this.todoData, newDate).subscribe(result => {
        if (result) {
          this._toastr.success('Todo added successfully', 'Sucess');
          this.loadData()
          formPost.reset();
          this.closeModal();
          // this.reRender();
        }
      });
    }
  }

  saveEditTodo() {
    let newDate = this.selectedTodo['date'].getFullYear() + "-" + this.twoDigits(1 + this.selectedTodo['date'].getMonth()) + "-" + this.twoDigits(this.selectedTodo['date'].getDate()) + " " + this.twoDigits(this.selectedTodo['date'].getHours()) + ":" + this.twoDigits(this.selectedTodo['date'].getMinutes()) + ":" + this.twoDigits(this.selectedTodo['date'].getSeconds());
    this._todoService.editTodo(this.selectedTodo, newDate).subscribe(result => {
      if (result) {
        this._toastr.success('Todo updated successfully', 'Sucess');
        this.loadData()
        this.closeModal();
      }
    });
  }

  deletePost() {
    this.todos.forEach(element => {
      if (element.isSelected)
        this.selectIds.push(element.id)
    });
    if (this.selectIds.length > 0) {
      this._todoService.deleteTodo(this.selectIds).subscribe(result => {
        if (result) {
          this._toastr.success('Todo deleted successfully', 'Sucess');
          this.loadData()
          this.closeModal();
        }
      });
    }
    else {
      this._toastr.warning('Please select any todo first', 'Info');
      this.closeModal();
    }
  }

  openModal(content, post?) {
    if (post) {
      this.selectedTodo = { ...post };
      var date = new Date(this.selectedTodo['date']);
      this.selectedTodo['date'] = date;
      this.selectIds.push(this.selectedTodo.id);
    }
    this._modalService.open(content, { ariaLabelledBy: 'modal-basic-title' })
  }

  closeModal() {
    this._modalService.dismissAll();
  }

  ngOnDestroy(): void {
    this.dtTrigger.unsubscribe();
  }
}
