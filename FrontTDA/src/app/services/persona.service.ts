import { Injectable } from '@angular/core';
import { forkJoin, Observable, switchMap } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Persona } from '../models/persona.model';
import { Usuario } from '../models/usuario.model';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {

  url= "http://localhost:8086/persona/";
  url2= "http://localhost:8086/usuario/";
  constructor(private http: HttpClient) { }

  obtenerFechaHoraActual(): string {
    const fecha = new Date();
    return `${fecha.getDate().toString().padStart(2, '0')}/${
      (fecha.getMonth() + 1).toString().padStart(2, '0')}/${
      fecha.getFullYear()} ${fecha.getHours().toString().padStart(2, '0')}:${
      fecha.getMinutes().toString().padStart(2, '0')}:${fecha.getSeconds().toString().padStart(2, '0')}`;
  }
  addPersona(persona: Persona, user: Usuario): Observable<any> {
    // Obtener el último ID para la persona y el usuario en paralelo
    return forkJoin({
      lastIdPersona: this.http.get<number>(this.url + 'getLastId'),
      lastIdUser: this.http.get<number>(this.url2 + 'getLastId')
    }).pipe(
      switchMap(({ lastIdPersona, lastIdUser }) => {
        // Configurar la información inicial para la persona
        persona.id = lastIdPersona + 1;
        persona.creado_en = this.obtenerFechaHoraActual();
        persona.creado_por = persona.id;
  
        // Configurar la información inicial para el usuario
        user.id = lastIdUser + 1;
        user.idPersona = persona.id;
        user.creado_en = this.obtenerFechaHoraActual();
        user.creado_por = user.id;
        // Crear el usuario y la persona en paralelo
        return forkJoin({
          user: this.http.post<Usuario>(this.url2 + 'create', user),
          persona: this.http.post<Persona>(this.url + 'create', persona)
        });
      })
    );
  }
  

}
