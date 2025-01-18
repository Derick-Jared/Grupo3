package TDA2024.Recepcion.exeption.handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import TDA2024.Recepcion.exeption.response.*;;
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    //Manejador de excepciones genericas
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex, WebRequest request){
        logger.error("Error no manejado: {}", request.getDescription(false), ex);
        ErrorResponse error = new ErrorResponse(
            "Error interno del servidor", 
            HttpStatus.INTERNAL_SERVER_ERROR.value(), 
            request.getDescription(false)
            );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Manejador para errores de solicitud incorrecta
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleBadRequestException(IllegalArgumentException ex, WebRequest request) {
        logger.error("Error de solicitud incorrecta: {}", ex.getMessage());
        ErrorResponse error = new ErrorResponse(
            ex.getMessage(), 
            HttpStatus.BAD_REQUEST.value(), 
            request.getDescription(false)
            );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> handleNullPointerException(NullPointerException ex, WebRequest request) {
        logger.error("NullPointerException: {}", ex.getMessage());
        ErrorResponse error = new ErrorResponse(
            "Recurso no encontrado", 
            HttpStatus.NOT_FOUND.value(), 
            request.getDescription(false)
            );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex, WebRequest request) {
        logger.error("Se ingreso un dato erroneo: {}", ex.getMessage());
        ErrorResponse error = new ErrorResponse(
            "Se ingreso un dato erroneo", 
            HttpStatus.BAD_REQUEST.value(), 
            request.getDescription(false)
            );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
