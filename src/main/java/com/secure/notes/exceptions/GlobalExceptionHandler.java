package com.secure.notes.exceptions;

import com.secure.notes.security.response.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // This catches the RuntimeException thrown by your NoteServiceImpl
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<MessageResponse> handleRuntimeException(RuntimeException ex) {
        // We reuse your existing MessageResponse class!
        MessageResponse errorResponse = new MessageResponse(ex.getMessage());
        
        // Return a 404 Not Found status with the message
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}