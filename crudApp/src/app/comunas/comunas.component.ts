import { Component, OnInit } from '@angular/core';
import { ComunaService } from '../comuna.service';
import { Empleado } from '../empleado';

@Component({
  selector: 'app-comunas',
  templateUrl: './comunas.component.html',
  styleUrls: ['./comunas.component.css']
})
export class ComunasComponent implements OnInit {
  comunas : String[];
  constructor(
   private comunaService : ComunaService
  ) { }

  ngOnInit(){
  }
  OnClick(){
    console.log("hola")
  }
  onChange() {
    console.log("hola");
}

}
