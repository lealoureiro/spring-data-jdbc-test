package org.leandroloureiro.demo.springdatajdbctest.configuration;

import org.leandroloureiro.demo.springdatajdbctest.model.ErrorMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlerConfiguration {

    @ExceptionHandler({IllegalArgumentException.class})
    ResponseEntity<ErrorMessage> handleBadArguments(IllegalArgumentException e) {

        return ResponseEntity.badRequest()
                .body(new ErrorMessage(e.getMessage()));

    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    ResponseEntity<ErrorMessage> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        return ResponseEntity.badRequest()
                .body(new ErrorMessage("Invalid argument: " + e.getParameter().getParameterName()));

    }


}
