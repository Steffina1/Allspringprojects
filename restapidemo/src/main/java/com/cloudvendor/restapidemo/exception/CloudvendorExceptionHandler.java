package com.cloudvendor.restapidemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CloudvendorExceptionHandler {
@ExceptionHandler(value = {CloudvendorNotFoundException.class})
    public ResponseEntity<Object> handleCloudVendorNotFoundException(CloudvendorNotFoundException cloudvendorNotFoundException) {
        CloudVendorException cloudVendorException = new CloudVendorException(
                cloudvendorNotFoundException.getMessage(),
                cloudvendorNotFoundException.getCause(),
                HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(cloudVendorException, HttpStatus.NOT_FOUND);

    }
}
