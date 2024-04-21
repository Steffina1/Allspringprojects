package com.cloudvendor.restapidemo.exception;

public class CloudvendorNotFoundException extends RuntimeException{
    public CloudvendorNotFoundException(String message) {
        super(message);
    }

    public CloudvendorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CloudvendorNotFoundException(Throwable cause) {
        super(cause);
    }
}
