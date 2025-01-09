import { Component, OnInit, ViewChild } from '@angular/core';
import { Usuario } from 'src/app/models/usuario.model';

import { UsuarioService } from 'src/app/services/usuario.service';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {

  usuarios: Usuario []=[];


  constructor(private usuarioService: UsuarioService){}

  ngOnInit(): void {
     this.loadUsuarios();
  }


  loadUsuarios(){
    console.log("entrando");
    this.usuarioService.getUsuarios().subscribe( //subscribe:PARA RESPUESTAS ASINCRONAS
      (response) => {this.usuarios = response;
        console.log("llega :"+response);
       },
      (error) => console.error("error en el loading", error)
    )
  }

}
