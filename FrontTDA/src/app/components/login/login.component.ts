import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Usuario } from 'src/app/models/usuario.model'
import { UsuarioService } from 'src/app/services/usuario.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginError: boolean = false;
  userForm!: FormGroup;
  user: Usuario | undefined;

  ngOnInit(): void {
    this.userForm = this.fb.group({
      email: [this.user?.email || '', Validators.required],
      password: [this.user?.password || '', [Validators.required]]
    })
  }

  constructor(private userService: UsuarioService, private fb: FormBuilder, private router: Router) {
    this.userForm = this.fb.group({
      email: [''],
      password: ['']
    })
  }

  onSubmit() {
    if (this.userForm.valid) {
      console.log(this.userForm.value);
      this.userService.login(this.userForm.value).subscribe(data => {
        console.log(data);
        if (data) {
          this.router.navigate(['/index']);
          this.loginError = false;
        } else {
          this.loginError = true;  
          this.router.navigate(['/login']);
          this.resetForm();
        }
      }, error => {
        console.log(error);
        this.loginError = true; 
      });
    }else{
      this.loginError = true;
    }
  }


  resetForm() {
    this.userForm.reset();
  }

}
