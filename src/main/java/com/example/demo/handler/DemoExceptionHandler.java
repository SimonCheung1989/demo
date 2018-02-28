package com.example.demo.handler;

import com.example.demo.exception.DemoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DemoExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({DemoException.class})
    public ResponseEntity handleDemoException(final DemoException demoException,
                                              final WebRequest request){

        return new ResponseEntity(demoException.toString(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity handleCommonException(final Exception exception, final WebRequest request) {
        return new ResponseEntity("Common exception", HttpStatus.CONFLICT);
    }
}
