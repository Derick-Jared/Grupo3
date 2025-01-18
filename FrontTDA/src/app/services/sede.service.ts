import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Sede } from '../models/sede.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SedeService {

  private url = "http://localhost:8098/Sede";

  constructor(private http: HttpClient) { }

  getAllHabSedes(): Observable<Sede[]> {
    return this.http.get<Sede[]>(`${this.url}/Hab`);
  }

  getSedeById(id: number): Observable<Sede[]> {
    return this.http.get<Sede[]>(`${this.url}/${id}`);
  }

  createSede(item: any): Observable<Sede> {
    return this.http.post<Sede>(`${this.url}/`,item);
  }

  updateSede(item: any): Observable<Sede> {
    return this.http.put<Sede>(`${this.url}`, item);
  }

  updateEstadoSede(item: any): Observable<Sede> {
    return this.http.put<Sede>(`${this.url}/Estado`, item);
  }
}
