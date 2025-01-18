import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { UsuarioComponent } from './components/usuario/usuario.component';
import { LoginComponent } from './components/login/login.component';
import { HttpClientModule } from '@angular/common/http';

import { CatalogoFormComponent } from './components/configuracion/catalogo-form/catalogo-form.component';
import { CatalogoComponent } from './components/configuracion/catalogo/catalogo.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ToastrModule } from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { EnvioComponent } from './components/envios/envio/envio.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { CreateEnvioComponent } from './components/envios/create-envio/create-envio.component';
import { SedeComponent } from './components/sede/sede/sede.component';
import { SedeFormComponent } from './components/sede/sede-form/sede-form.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,

    UsuarioComponent,
    LoginComponent,
    CatalogoComponent,
    CatalogoFormComponent,
    EnvioComponent,
    CreateEnvioComponent,
    SedeComponent,
    SedeFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    NgbModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot({
      timeOut: 3000,
      positionClass: 'toast-top-right', 
      preventDuplicates: false,
      progressBar: true
    }),
    NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
