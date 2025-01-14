import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators,FormsModule } from '@angular/forms';
import { Usuario } from 'src/app/models/usuario.model'
import { Persona } from 'src/app/models/persona.model'
import { PersonaService } from 'src/app/services/persona.service';
import { Router } from '@angular/router';
import { AlertifyService } from 'src/app/services/alertify.service';



@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit{
  personaForm!: FormGroup;
  userForm!: FormGroup;
  tipo_documento: String = 'DNI';
  user: Usuario | undefined;
  persona: Persona | undefined;
  fechaHoraActual: string = '';
  camposObligatorios: boolean = false;

  ngOnInit(): void {
    this.personaForm = this.fb.group({
      tipo_documento: [this.persona?.tipo_documento || '', Validators.required],
      cedula: [this.persona?.cedula || '', [Validators.required]],
      nombres: [this.persona?.nombres || '', ],
      apellidos: [this.persona?.apellidos || '', ],
      razon_social: [this.persona?.razon_social || '', ],
      email: [this.persona?.email || '', [Validators.required]],
      direccion: [this.persona?.direccion || ''],
      telefono: [this.persona?.telefono || ''],
      password: [this.user?.password || '', [Validators.required]]
    })

    this.userForm = this.fb.group({
      email: [this.user?.email || ''],
      password: [this.user?.password ||'']
    })
  }

  constructor(private personaService: PersonaService, private fb: FormBuilder, private router: Router,private alertify: AlertifyService) {
      this.personaForm = this.fb.group({
        tipo_documento: [''],
        cedula: [''],
        nombres: [''],
        apellidos: [''],
        razon_social: [''],
        email: [''],
        direccion: [''],
        telefono: [''],
        password: ['']
      })

      this.userForm = this.fb.group({
        email: [''],
        password: ['']
      })
    }

    onSubmit() {
      console.log(this.personaForm.value);
      this.userForm.patchValue({ 
        email:this.personaForm.value.email,
        password: this.personaForm.value.password
      })
      console.log(this.userForm.value);

      if (this.personaForm.valid) {
        this.personaService.addPersona(this.personaForm.value,this.userForm.value).subscribe(data=>{
          console.log(data);
          if (data) {
            this.router.navigate(['/index']).then(() => {
              this.alertify.success('¡Se Registro Correctamente!');
            });
            this.camposObligatorios=false;
          } else { 
            this.router.navigate(['/register']);
            this.camposObligatorios=true;
          }
          this.resetForm();
          
        }, error => {
          console.log(error); 
        });
      }else{
        this.camposObligatorios=true;
      }
    }

    
    toUpperCase(controlName: string): void {
      const control = this.personaForm.get(controlName);
      if (control) {
        const value = control.value || '';
        control.setValue(value.toUpperCase(), { emitEvent: false });
      }
    }

    resetForm() {
      this.userForm.reset();
    }
}
