import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Empleado } from './empleado';
import { Observable } from 'rxjs';

@Injectable()
export class EmpleadoServiceService {

  empleadosUrl : string;
  regionesUrl : string;
  findUrl : string;
  updateUrl : string;
  identificacion : string;

  constructor(private http: HttpClient) { 
    this.regionesUrl = 'http://localhost:8080/regiones'; 
    this.empleadosUrl = 'http://localhost:8080/empleados';
    this.findUrl = 'http://localhost:8080/find/';
    this.updateUrl = 'http://localhost:8080/actualizar';
  }

  public findAll(): Observable<Empleado[]>{
    return this.http.get<Empleado[]>(this.empleadosUrl);
  }

  public keep(identificacion : string){
    return this.identificacion = identificacion;
  }
  public update(empleado : Empleado){
    return this.http.put<Empleado>(this.updateUrl,empleado);
  }
  public find(id : string){
    return this.http.get<Empleado>(`${this.findUrl}${id}`);
  }

  public save(empleado: Empleado){
    return this.http.post<Empleado>(this.empleadosUrl,empleado);
  }

  public destroy(url : string){
    return this.http.delete(url);
  }

}
