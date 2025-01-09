import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UsuarioComponent } from './components/usuario/usuario.component';
import { LoginComponent } from './components/login/login.component';


const routes: Routes = [
  //BRE A LLAMAR EN LA URL
  { path: 'login', component: LoginComponent },
  { path: 'gestionusuario', component: UsuarioComponent },
  { path: '', redirectTo: '/gestionusuario', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
