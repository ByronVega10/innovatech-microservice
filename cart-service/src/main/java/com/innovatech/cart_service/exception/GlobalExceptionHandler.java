package com.innovatech.cart_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice // Anotación que convierte esta clase en un manejador de excepciones global.
public class GlobalExceptionHandler {

    /**
     * Este método se activará cada vez que la validación de @Valid falle.
     * @param ex La excepción que contiene todos los detalles de los errores de validación.
     * @return Un mapa con los campos que fallaron y sus mensajes de error.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        
        // Recorremos la lista de todos los errores de campo.
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            // Obtenemos el nombre del campo que falló.
            String fieldName = ((FieldError) error).getField();
            // Obtenemos el mensaje de error que definimos en la entidad.
            String errorMessage = error.getDefaultMessage();
            // Añadimos el campo y su error al mapa.
            errors.put(fieldName, errorMessage);
        });
        
        return errors;
    }
}
