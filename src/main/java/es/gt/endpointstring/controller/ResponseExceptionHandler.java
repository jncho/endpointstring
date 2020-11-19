package es.gt.endpointstring.controller;

import es.gt.endpointstring.model.StringRecord;
import es.gt.endpointstring.model.StringRecordError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResponseExceptionHandler
        extends ResponseEntityExceptionHandler {

    // Handle 400 Bad Request error
    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            MissingServletRequestParameterException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {

        StringRecordError apiError =
                new StringRecordError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),((ServletWebRequest)request).getRequest().getServletPath());
        return new ResponseEntity<Object>(
                apiError, new HttpHeaders(), apiError.getStatus());
    }

    // Handle 404 Bad Request error
    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        StringRecordError apiError =
                new StringRecordError(HttpStatus.NOT_FOUND, ex.getLocalizedMessage(),((ServletWebRequest)request).getRequest().getServletPath());
        return new ResponseEntity<Object>(
                apiError, new HttpHeaders(), apiError.getStatus());
    }
}