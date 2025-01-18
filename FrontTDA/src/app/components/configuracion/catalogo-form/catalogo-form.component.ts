import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Catalogo } from 'src/app/models/catalogo.model';
import { CatalogoService } from 'src/app/services/catalogo.service';

@Component({
  selector: 'app-catalogo-form',
  templateUrl: './catalogo-form.component.html',
  styleUrls: ['./catalogo-form.component.css']
})
export class CatalogoFormComponent implements OnInit {

  catalogoForm!: FormGroup;
  catalogo: Catalogo | undefined;
  tipo!: string;
  accion!: string;
  constructor(private fb: FormBuilder, public activateModal: NgbActiveModal, private catalogoService: CatalogoService) { }

  onSubmit(){
    if(this.catalogoForm.valid){
      this.activateModal.close(this.catalogoForm.value);
    }
  }

  getErrorMessage(controlName: string): string {
    const control = this.catalogoForm.get(controlName);
    if (control?.hasError('required')) {
      return 'Este campo es obligatorio.';
    }
    if (control?.hasError('maxlength')) {
      const maxLength = control?.getError('maxlength').requiredLength;
      return `No debe exceder los ${maxLength} caracteres.`;
    }
    return '';
  }

  ngOnInit(): void {
    this.catalogoForm = this.fb.group({
      id: [this.catalogo?.id],
      tabla: [this.catalogo?.tabla],
      item: [this.catalogo?.item],
      descripcion_corta: [this.catalogo?.descripcion_corta, [Validators.required, Validators.maxLength(5)]],
      descripcion_larga: [this.catalogo?.descripcion_larga, [Validators.required, Validators.maxLength(100)]],
      estado: [this.catalogo?.estado]
    })
  }
}
