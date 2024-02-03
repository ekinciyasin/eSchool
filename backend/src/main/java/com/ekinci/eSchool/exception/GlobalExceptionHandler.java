package com.ekinci.eSchool.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgValidEx(MethodArgumentNotValidException exception, HttpServletRequest request){

       ApiError apiError = new ApiError();
       apiError.setPath(request.getRequestURI());
       apiError.setMessage("Validation error");
       apiError.setStatus(400);
//        Map<String, String> validationErrors = new HashMap<>();
//        List<FieldError> errors = exception.getBindingResult().getFieldErrors();
//        for (FieldError fieldError: errors){
//            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
//        }
        var validationErrors = exception.getBindingResult().getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage,(existing,replacing)->existing));
        apiError.setValidationErrors(validationErrors);
    return ResponseEntity.badRequest().body(apiError);

    }
}
