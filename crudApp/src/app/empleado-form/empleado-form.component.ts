import { Component, DoCheck, OnChanges, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Empleado } from '../empleado';
import { EmpleadoServiceService } from '../empleado-service.service';
import { ComunaService } from '../comuna.service';

@Component({
  selector: 'app-empleado-form',
  templateUrl: './empleado-form.component.html',
  styleUrls: ['./empleado-form.component.css']
})
export class EmpleadoFormComponent implements OnInit{
  empleado : Empleado;
  comunas : String[];
  comunasUrl : string;
  constructor(
    private route : ActivatedRoute,
      private router: Router,
        private empleadoService: EmpleadoServiceService,
        private comunaService : ComunaService
        ) {
      this.empleado = new Empleado();
  }
  
  onSubmit() {
    this.empleadoService.save(this.empleado).subscribe(result => this.gotoEmpleadoList());
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
  ngOnInit(){
    return this.comunaService.findComunas().subscribe(data=>{
       this.comunas = data;
     });
   }
  


}
