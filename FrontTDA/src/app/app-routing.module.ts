import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UsuarioComponent } from './components/usuario/usuario.component';
import { LoginComponent } from './components/login/login.component';
import { CatalogoComponent } from './components/configuracion/catalogo/catalogo.component';


const routes: Routes = [
  //BRE A LLAMAR EN LA URL
  { path: 'login', component: LoginComponent },
  { path: 'gestionusuario', component: UsuarioComponent },
  { path: '', redirectTo: '/gestionusuario', pathMatch: 'full' },
  { path: 'catalogo', component: CatalogoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
