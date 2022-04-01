import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable()
export class ComunaService {
  constructor(private http : HttpClient) {
   }

  public findComunas() : Observable<String[]>{
    return this.http.get<String[]>(`http://localhost:8080/comunas/Tarapacá`);
  }

  
  public changeUrl(url : string): Observable<String[]>{
    return this.http.get<String[]>(`http://localhost:8080/comunas/${url}`);
  }
}
