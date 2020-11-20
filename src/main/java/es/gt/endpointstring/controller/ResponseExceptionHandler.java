package es.gt.endpointstring.controller;

import es.gt.endpointstring.model.StringRecordError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResponseExceptionHandler
        extends ResponseEntityExceptionHandler {

    // Handle 400 Bad Request error
    // Empty body
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        StringRecordError apiError =
                new StringRecordError(HttpStatus.BAD_REQUEST, "Required request body is missing",((ServletWebRequest)request).getRequest().getServletPath());
        return new ResponseEntity<Object>(
                apiError, new HttpHeaders(), apiError.getStatus());
    }

    // Missing argument
    @Override
    protected ResponseEntity<Object> handleMissingServletRequestPart(MissingServletRequestPartException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        StringRecordError apiError =
                new StringRecordError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),((ServletWebRequest)request).getRequest().getServletPath());
        return new ResponseEntity<Object>(
                apiError, new HttpHeaders(), apiError.getStatus());
    }


    // Handle 404 Not Found error
    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        StringRecordError apiError =
                new StringRecordError(HttpStatus.NOT_FOUND, ex.getLocalizedMessage(),((ServletWebRequest)request).getRequest().getServletPath());
        return new ResponseEntity<Object>(
                apiError, new HttpHeaders(), apiError.getStatus());
    }

    // Handle incorrect use of Methods
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        StringRecordError apiError =
                new StringRecordError(HttpStatus.METHOD_NOT_ALLOWED, ex.getLocalizedMessage(),((ServletWebRequest)request).getRequest().getServletPath());
        return new ResponseEntity<Object>(
                apiError, new HttpHeaders(), apiError.getStatus());
    }
}