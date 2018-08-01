package com.parkingtelecom.errors;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    protected ResponseEntity<Object> handleErrors(Error e, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "Errors....";
        return new ResponseEntity<>(new ErrorResponse(OffsetDateTime.now(), error), HttpStatus.BAD_REQUEST);
    }


    protected ResponseEntity<Object> handleException(Exception ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "Ooops, something goes wrong!";
        return new ResponseEntity<>(new ErrorResponse(OffsetDateTime.now(), error), HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "Error writing JSON output";
        return new ResponseEntity<>(new ErrorResponse(OffsetDateTime.now(), error), HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "Malformed JSON request";
        return new ResponseEntity<>(new ErrorResponse(OffsetDateTime.now(), error), HttpStatus.BAD_REQUEST);
    }
}
