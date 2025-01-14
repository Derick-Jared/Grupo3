import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from '../models/usuario.model';

import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  url= "http://localhost:8086/usuario/";

  constructor( private http: HttpClient) { }

  getUsuarios(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(this.url+"all");
  }

  login(user : any): Observable<Usuario>{
    console.log('como esta entrando :'+user.email+" "+user.password);
    return this.http.post<Usuario>(this.url+"login",user);
  }


  getUsuariosByEstado(estado :String): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(this.url+"allByEstado/"+estado);
  }
}
