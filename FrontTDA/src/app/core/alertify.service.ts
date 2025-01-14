import { Injectable } from '@angular/core';

declare let alertify: any;


@Injectable({
  providedIn: 'root'
})
export class AlertifyService {

  constructor() { }

  confirm(message: string, okCallback: () => any) {
    alertify.confirm(message, function(e: any) {
      if (e) {
        okCallback();
      }
    });
  }

  confirm2(
    message: string,
    okCallback: () => any,
    cancelCallback: () => any,
    options?: { okText?: string; cancelText?: string; title?: string }
  ) {
    alertify.confirm(
      options?.title || "Confirmación",
      message,
      function () {
        okCallback();
      },
      function () {
        cancelCallback();
      }
    ).set({
      labels: {
        ok: options?.okText || "OK",
        cancel: options?.cancelText || "Cancelar"
      }
    });
  }
  

  success(message: string) {
    alertify.success(message);
  }

  error(message: string) {
    alertify.error(message);
  }

  warning(message: string) {
    alertify.warning(message);
  }

  message(message: string) {
    alertify.message(message);
  }
}
