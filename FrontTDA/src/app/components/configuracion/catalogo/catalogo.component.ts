import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Catalogo } from 'src/app/models/catalogo.model';
import { CatalogoFormComponent } from '../catalogo-form/catalogo-form.component';
import { CatalogoService } from 'src/app/services/catalogo.service';

@Component({
  selector: 'app-catalogo',
  templateUrl: './catalogo.component.html',
  styleUrls: ['./catalogo.component.css']
})
export class CatalogoComponent implements OnInit {

  catalogoForm!: FormGroup;
  tablaList!: Catalogo[];
  ItemList!: Catalogo[];
  tablaSelec: number = -1;

  constructor(private catalogoService: CatalogoService ,private fb: FormBuilder, private modalService : NgbModal) {
    this.catalogoForm = this.fb.group({
      id: [0],
      tabla: [0],
      item: [0],
      descripcion_corta: [''],
      descripcion_larga: [''],
      estado: ['']
    });
    
  }

  loadTablas(){
    this.catalogoService.getTablas().subscribe( 
      (response) => this.tablaList = response,
      (error) => console.error("error en el loading",error)
    )
  }

  loadItems(tabla:number){
    this.tablaSelec = tabla;
    this.catalogoService.getItems(tabla).subscribe( 
      (response) => this.ItemList = response,
      (error) => console.error("error en el loading",error)
    )
  }

  openCatalogoModal(catalogo?: Catalogo | null, accion?: string, tipo?: string){
    const modalRef = this.modalService.open(CatalogoFormComponent);
    modalRef.result.then( (result) => {
      if(result){
        if(result.id){
          
        }
        else{
          
        }
      }
    })
    .catch((error) => {
      console.warn("Modal cerrado");
    })
  }
  
  ngOnInit(): void {
    this.loadTablas();
  }
}
