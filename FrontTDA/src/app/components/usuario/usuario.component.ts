import { Component, OnInit, ViewChild } from '@angular/core';
import { Usuario } from 'src/app/models/usuario.model';

import { UsuarioService } from 'src/app/services/usuario.service';
import { AlertifyService } from 'src/app/core/alertify.service';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {
  user: Usuario | undefined;
  usuarios: Usuario []=[];
  usuarios2: Usuario []=[];


  constructor(private usuarioService: UsuarioService,private alertify :AlertifyService){}

  ngOnInit(): void {
     this.loadUsuarios();
  }


  loadUsuarios(){
    console.log("entrando");
    this.usuarioService.getUsuariosByEstado("ACTVO").subscribe( 
      (response) => {this.usuarios = response;
        console.log("llega :"+response);
       },
      (error) => console.error("error en el loading", error)
    )

    this.usuarioService.getUsuariosByEstado("DSTVO").subscribe( 
      (response) => {this.usuarios2 = response;
        console.log("llega2 :"+response);
       },
      (error) => console.error("error en el loading2", error)
    )
  }

  openUserModal(user?: Usuario) {
    this.alertify.confirm2(
      "¿Estás seguro que deseas activar este usuario?",
      () => {
        this.alertify.success('El usuario ha sido activado.');
        alert(user?.email)
      },
      () => {
        this.alertify.error('La acción ha sido cancelada.');
      },
      { okText: "Si", cancelText: "No", title: "Activar Usuario" }
    );
  }
  
  

}
