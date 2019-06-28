import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ToDoComponent } from '../app/component/to-do/to-do.component';

const routes: Routes = [
  { path: 'to-do', component: ToDoComponent },
  { path: '', component: ToDoComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
