import { Component, OnInit } from '@angular/core';
import { Empleado } from '../empleado';
import { EmpleadoServiceService } from '../empleado-service.service';
import { Router,ActivatedRoute} from '@angular/router';
@Component({
  selector: 'app-empleado-list',
  templateUrl: './empleado-list.component.html',
  styleUrls: ['./empleado-list.component.css']
})
export class EmpleadoListComponent implements OnInit {
  empleados : Empleado[];
  //estoy pasando como parametro del constructor el servicio que maneja las 
  //peticiones http, basicamente estoy inyectando el objeto como una dependencia 
  //dentro de esta clase/componente.
  constructor(private empleadoService : EmpleadoServiceService,    private route : ActivatedRoute,
    private router: Router) { }

  delete(id : string){
    this.empleadoService.destroy(`http://localhost:8080/delete/${id}`).subscribe(result => result);
  }
  edit(id : string){
    return this.empleadoService.keep(id);
  }
  ngOnInit(){
    this.empleadoService.findAll().subscribe(data =>{
      this.empleados = data;
    })
  }

}
