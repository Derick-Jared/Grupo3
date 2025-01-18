import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastService } from 'src/app/core/toast.service';
import { Sede } from 'src/app/models/sede.model';
import { SedeService } from 'src/app/services/sede.service';
import { SedeFormComponent } from '../sede-form/sede-form.component';
import { CatalogoService } from 'src/app/services/catalogo.service';
import { Catalogo } from 'src/app/models/catalogo.model';
import { forkJoin } from 'rxjs';

@Component({
  selector: 'app-sede',
  templateUrl: './sede.component.html',
  styleUrls: ['./sede.component.css']
})
export class SedeComponent implements OnInit {
  sedeForm!: FormGroup;
  buscar: string = "";
  sedeLista?: Sede[];
  page: number = 1;
  pageSize: number = 5;

  listaPaisMap: Map<string, string> = new Map();
  listaCiudadMap: Map<string, string> = new Map();
  listaDepartamentoMap: Map<string, string> = new Map();

  constructor(private sedeService: SedeService, private catalogoService: CatalogoService, private fb: FormBuilder, private modalService: NgbModal,
    private toasteService: ToastService) {
    this.sedeForm = this.fb.group({
      id: [0],
      nombre: [''],
      direccion: [''],
      ciudad: [''],
      pais: [''],
      departamento: [''],
      telefono: [''],
      estado: ['']
    });
  }

  loadSedes() {
    this.sedeService.getAllHabSedes().subscribe((result) => {
      for (let index = 0; index < result.length; index++) {
        result[index].paisDesc = this.getDescripcionLargaFromMap(0,result[index].pais);
        result[index].departamentoDesc = this.getDescripcionLargaFromMap(1,result[index].departamento);
        result[index].ciudadDesc = this.getDescripcionLargaFromMap(2,result[index].ciudad);
      }
      this.sedeLista = result;
    })
  }

  loadSelects() {
    forkJoin({
      paises: this.catalogoService.getItems(5),
      departamentos: this.catalogoService.getItems(7),
      ciudades: this.catalogoService.getItems(6),
    }).subscribe(({ paises, departamentos, ciudades }) => {
      paises.forEach(item => this.listaPaisMap.set(item.descripcion_corta, item.descripcion_larga));
      departamentos.forEach(item => this.listaDepartamentoMap.set(item.descripcion_corta, item.descripcion_larga));
      ciudades.forEach(item => this.listaCiudadMap.set(item.descripcion_corta, item.descripcion_larga));
      this.loadSedes();
    });
  }

  getDescripcionLargaFromMap(nun:number, corta: string): string {
    if(nun === 0) return this.listaPaisMap.get(corta) || "Sin asignar";
    if(nun === 1) return this.listaDepartamentoMap.get(corta) || "Sin asignar";
    if(nun === 2) return this.listaCiudadMap.get(corta) || "Sin asignar";
    return 'Sin asignar';
  }

  openRegisterModal(sede?: Sede | null, accion?: string) {
    const modalRef = this.modalService.open(SedeFormComponent);

    modalRef.componentInstance.accion = accion;
    modalRef.componentInstance.sede = sede;
    modalRef.result.then((result) => {
      if (result) {
        if (result.id) {
          this.toasteService.showSuccess("ingreasndo al uodate");
          this.sedeService.updateSede(result).subscribe(() => {
            this.toasteService.showSuccess("Registro actualizado correctamente");
            this.loadSedes();
          }, (error) => {
            this.toasteService.showError("Opps, ocurrio un problema, " + error.error.message);
          })
        }
        else {
          this.toasteService.showSuccess("ingresando al create");
          console.log(result);
          this.sedeService.createSede(result).subscribe(() => {
            this.toasteService.showSuccess("Registro guardado correctamente");
            this.loadSedes();
          }, (error) => {
            this.toasteService.showError("Opps, ocurrio un problema, " + error.error.message);
          })
        }
      }
    })
      .catch((error) => {
        console.warn("Modal cerrado");
      })
  }

  ngOnInit(): void {
    this.loadSelects();
  }
}
