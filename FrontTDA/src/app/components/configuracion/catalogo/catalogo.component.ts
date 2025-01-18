import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Catalogo } from 'src/app/models/catalogo.model';
import { CatalogoFormComponent } from '../catalogo-form/catalogo-form.component';
import { CatalogoService } from 'src/app/services/catalogo.service';
import { ToastService } from 'src/app/core/toast.service';

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
  idTablaSelec: number = -1;
  descCor!: string;
  descLar!: string;

  constructor(private catalogoService: CatalogoService ,private fb: FormBuilder, private modalService : NgbModal, 
    private toasteService: ToastService) {
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

  loadItems(tabla:number, idTabla:number, desCorta?:string, desLarga?:string){
    this.tablaSelec = tabla;
    this.idTablaSelec = idTabla;
    if(desCorta && desLarga){
      this.descCor = desCorta;
      this.descLar = desLarga;
    }
    this.catalogoService.getItems(tabla).subscribe( 
      (response) => this.ItemList = response,
      (error) => console.error("error en el loading",error)
    )
  }

  openCatalogoModal(catalogo?: Catalogo | null, accion?: string, tipo?: string){
    const modalRef = this.modalService.open(CatalogoFormComponent);

    if(accion == "editar" && tipo == "tabla"){
      catalogo = {
        id: this.idTablaSelec,
        tabla: this.tablaSelec,
        item: 0,
        descripcion_corta: this.descCor,
        descripcion_larga: this.descLar,
        estado: 'HAB'
      }
    }
    
    modalRef.componentInstance.accion = accion;
    modalRef.componentInstance.tipo = tipo;
    if(catalogo) modalRef.componentInstance.catalogo = catalogo;
    modalRef.result.then( (result) => {
      if(result){
        if(result.id){
          this.catalogoService.updateItem(result).subscribe( () => {
            this.toasteService.showSuccess("Registro actualizado correctamente");
            if(tipo == "tabla"){
              this.loadTablas();
              this.tablaSelec = -1;
            }
            else{
              this.loadItems(this.tablaSelec, this.idTablaSelec, this.descCor, this.descLar);
            }
          }, (error) => {
            this.toasteService.showError("Opps, ocurrio un problema o un campo que ya existe.");
          })
        }
        else{
          let tabla = tipo == "tabla" ? 0 : this.tablaSelec;
          result.tabla = tabla;
          this.catalogoService.createItem(result).subscribe( () => {
            this.toasteService.showSuccess("Registro guardado correctamente");
            if(tipo == "tabla"){
              this.loadTablas();
              this.tablaSelec = -1;
            }
            else{
              this.loadItems(this.tablaSelec, this.idTablaSelec, this.descCor, this.descLar);
            }
          }, (error) => {
            this.toasteService.showError("Opps, ocurrio un problema o un campo que ya existe.");
          })
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
