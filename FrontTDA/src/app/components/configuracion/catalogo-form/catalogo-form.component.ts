import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Catalogo } from 'src/app/models/catalogo.model';

@Component({
  selector: 'app-catalogo-form',
  templateUrl: './catalogo-form.component.html',
  styleUrls: ['./catalogo-form.component.css']
})
export class CatalogoFormComponent implements OnInit {

  catalogoForm!: FormGroup;
  catalogo!: Catalogo;
  constructor(private fb: FormBuilder, public activateModal: NgbActiveModal) { }

  ngOnInit(): void {
    this.catalogoForm = this.fb.group({
      id: [this.catalogo.id],
      tabla: [this.catalogo.tabla],
      item: [this.catalogo.item],
      descripcion_corta: [this.catalogo.descripcion_corta, [Validators.required, Validators.maxLength(255)]],
      descripcion_larga: [this.catalogo.descripcion_larga, [Validators.required, Validators.maxLength(5)]],
      estado: [this.catalogo.estado]
    })
  }
}
