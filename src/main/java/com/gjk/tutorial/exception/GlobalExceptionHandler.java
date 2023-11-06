package com.gjk.tutorial.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(GjKException.class)
    public ResponseEntity<GjKException> handelEmptyInput(GjKException ex, WebRequest request){

        GjKException gjKException1 = new GjKException(ErrorCode.valueOf(ErrorCode.STUDENT_ID_WITH_NO_DATA_FOUND.toString()), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(gjKException1);

    }
}
