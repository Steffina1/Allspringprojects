package com.cloudvendor.restapidemo.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> responsehandleremployee(String message, HttpStatus httpStatus, Object responseObject) {
        Map<String, Object> customresponse= new HashMap<String, Object>();
        customresponse.put("message", message);
        customresponse.put("httpstatus", httpStatus);
        customresponse.put("data", responseObject);
        return new ResponseEntity<Object>(customresponse, httpStatus);

    }
}
