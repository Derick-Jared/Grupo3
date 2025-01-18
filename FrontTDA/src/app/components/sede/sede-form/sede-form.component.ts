import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Catalogo } from 'src/app/models/catalogo.model';
import { Sede } from 'src/app/models/sede.model';
import { CatalogoService } from 'src/app/services/catalogo.service';
import { SedeService } from 'src/app/services/sede.service';

@Component({
  selector: 'app-sede-form',
  templateUrl: './sede-form.component.html',
  styleUrls: ['./sede-form.component.css']
})
export class SedeFormComponent {
  sedeForm!: FormGroup;
  sede: Sede | undefined;
  listaPais?: Catalogo[];
  listaDepartamento?: Catalogo[];
  listaCiudad?: Catalogo[];
  tipo!: string;
  accion!: string;
  constructor(private fb: FormBuilder, public activateModal: NgbActiveModal, private catalogoService: CatalogoService) { }

  onSubmit(){
    if(this.sedeForm.valid){
      this.activateModal.close(this.sedeForm.value);
    }
  }

  loadSelects(){
    this.catalogoService.getItems(5).subscribe(response => {
      this.listaPais = response;
    });

    this.catalogoService.getItems(7).subscribe(response => {
      this.listaDepartamento = response;
    })

    this.catalogoService.getItems(6).subscribe(response => {
      this.listaCiudad = response;
    })
  }

  getErrorMessage(controlName: string): string {
    const control = this.sedeForm.get(controlName);
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
    this.loadSelects();
    this.sedeForm = this.fb.group({
      id: [this.sede?.id],
      nombre: [this.sede?.nombre, [Validators.required, Validators.maxLength(255)]],
      direccion: [this.sede?.direccion, [Validators.required, Validators.maxLength(255)]],
      pais: [this.sede?.pais, [Validators.required, Validators.maxLength(5)]],
      departamento: [this.sede?.departamento, [Validators.required, Validators.maxLength(5)]],
      ciudad: [this.sede?.ciudad, [Validators.required, Validators.maxLength(5)]],
      telefono: [this.sede?.telefono, [Validators.required, Validators.maxLength(15)]],
      estado: [this.sede?.estado == null ? "HAB" : this.sede?.estado]
    })
  }
}
