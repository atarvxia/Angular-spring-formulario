import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { EmpleadoListComponent } from './empleado-list/empleado-list.component';
import { EmpleadoFormComponent } from './empleado-form/empleado-form.component';
import { EmpleadoServiceService } from './empleado-service.service';
import { ComunasComponent } from './comunas/comunas.component';
import { ComunaService } from './comuna.service';
import { EditFormComponent } from './edit-form/edit-form.component';

@NgModule({
  declarations: [
    AppComponent,
    EmpleadoListComponent,
    EmpleadoFormComponent,
    ComunasComponent,
    EditFormComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [EmpleadoServiceService,ComunaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
