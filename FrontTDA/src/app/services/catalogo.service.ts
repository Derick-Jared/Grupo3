import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Catalogo } from '../models/catalogo.model';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CatalogoService {

  url= "http://localhost:8095/Catalogo";
  
    constructor( private http: HttpClient) { }
  
    getTablas(): Observable<Catalogo[]> {
      return this.http.get<Catalogo[]>(`${this.url}/Tabla/Listar`);
    }

    getItems(tabla:number): Observable<Catalogo[]> {
      return this.http.get<Catalogo[]>(`${this.url}/Tabla/Listar/${tabla}`);
    }

    getItemDescripcion(desc:string): Observable<Catalogo> {
      return this.http.get<Catalogo>(`${this.url}/Item/${desc}`);
    }

    createItem(item:any): Observable<Catalogo> {
      return this.http.post<Catalogo>(`${this.url}/Item`,item);
    }

    updateItem(item:any): Observable<Catalogo> {
      return this.http.put<Catalogo>(`${this.url}/Item`,item);
    }
}
