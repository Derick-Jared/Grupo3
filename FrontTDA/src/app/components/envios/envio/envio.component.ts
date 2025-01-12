import { Component, OnInit } from '@angular/core';
import { Envio } from 'src/app/models/envio.model';
import { EnvioService } from 'src/app/services/envio.service';

@Component({
  selector: 'app-envio',
  templateUrl: './envio.component.html',
  styleUrls: ['./envio.component.css']
})
export class EnvioComponent implements OnInit{

  buscar: string = "";
  envioLista?: Envio[];
  page: number = 1; 
  pageSize: number = 5;
  constructor(private envioService: EnvioService) { }

  loadEnvios(){
    this.envioService.getAllHab().subscribe( (result) => {
      this.envioLista = result;
    })
  }

  ngOnInit(): void {
      this.loadEnvios();
  }
}
