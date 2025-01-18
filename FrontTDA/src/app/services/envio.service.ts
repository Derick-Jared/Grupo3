import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Envio } from '../models/envio.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EnvioService {

  url = "http://localhost:8098/Envios";

  constructor(private http: HttpClient) { }

  getAllHab(): Observable<Envio[]> {
    return this.http.get<Envio[]>(`${this.url}/Hab`);
  }

  getAll(): Observable<Envio[]> {
    return this.http.get<Envio[]>(`${this.url}`);
  }

  getByUser(idUsuario: number): Observable<Envio[]> {
    return this.http.get<Envio[]>(`${this.url}/User/${idUsuario}`);
  }

  getById(id: number): Observable<Envio> {
    return this.http.get<Envio>(`${this.url}/${id}`);
  }

  createEnvio(item: any): Observable<Envio> {
    return this.http.post<Envio>(`${this.url}`, item);
  }

  updateEnvio(item: any): Observable<Envio> {
    return this.http.put<Envio>(`${this.url}`, item);
  }

  updateEstadoEnvio(item: any): Observable<Envio> {
    return this.http.put<Envio>(`${this.url}`, item);
  }
}
