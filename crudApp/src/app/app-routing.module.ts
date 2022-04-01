import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmpleadoListComponent } from './empleado-list/empleado-list.component';
import { EmpleadoFormComponent } from './empleado-form/empleado-form.component';
import { EditFormComponent } from './edit-form/edit-form.component';
const routes: Routes = [
  {path: 'empleados', component: EmpleadoListComponent},
  {path: 'addempleado', component: EmpleadoFormComponent},
  {path: 'editarempleado', component: EditFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
