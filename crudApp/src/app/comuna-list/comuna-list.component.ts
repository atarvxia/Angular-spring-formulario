import { Component, OnInit } from '@angular/core';
import { EmpleadoServiceService } from '../empleado-service.service';
import { Comuna } from '../comuna';

@Component({
  selector: 'app-comuna-list',
  templateUrl: './comuna-list.component.html',
  styleUrls: ['./comuna-list.component.css']
})
export class ComunaListComponent implements OnInit {

  comunas : Comuna[];
  constructor(private empleadoService : EmpleadoServiceService) { }

  ngOnInit(){

  }
  //necesito algun tipo de dependencia u servicio

}
