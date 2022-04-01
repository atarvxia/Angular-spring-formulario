import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Empleado } from '../empleado';
import { EmpleadoServiceService } from '../empleado-service.service';
import { ComunaService } from '../comuna.service';
@Component({
  selector: 'app-edit-form',
  templateUrl: './edit-form.component.html',
  styleUrls: ['./edit-form.component.css']
})
export class EditFormComponent implements OnInit {
  empl : Empleado;
  empleado : Empleado;
  comunas : String[];
  comunasUrl : string;
  constructor(private empleadoService : EmpleadoServiceService,
    private route : ActivatedRoute,
    private router: Router,
    private comunaService : ComunaService) {
      this.empleado = new Empleado();
     }
     onSubmit() {
       this.empleado.id = this.empl.id;
      this.empleadoService.update(this.empleado).subscribe(result => this.gotoEmpleadoList());
    }
    gotoEmpleadoList() {
      this.router.navigate(['/empleados']);
    }
    onChange(e : any | null){
      this.comunasUrl = e.value;
      return this.comunaService.changeUrl(this.comunasUrl).subscribe(data=>{
        this.comunas = data;
      });
    }  
//if (empleado.nombre === undefined || empleado.nombre === null){empleado.nombre = empl.nombre}
  ngOnInit(){
    this.empleadoService.find(this.empleadoService.identificacion).subscribe(data=>{
     this.empl = data;
     console.log(this.empl);
     this.comunaService.findComunas().subscribe(data=>{
       console.log(data);
      this.comunas = data;
    });
    })
  }

}
