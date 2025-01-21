import { Injectable } from '@angular/core';
import { ToastrService } from 'ngx-toastr';

@Injectable({
  providedIn: 'root'
})
export class ToastService {

  constructor(private toastr: ToastrService) {}

  showSuccess(mesagge:string) {
    this.toastr.success(mesagge, 'Éxito');
  }

  showError(mesagge:string) {
    this.toastr.error(mesagge, 'Error');
  }

  showWarning(mesagge:string) {
    this.toastr.warning(mesagge, 'Advertencia');
  }

  showInfo(mesagge:string) {
    this.toastr.info(mesagge, 'Información');
  }
}