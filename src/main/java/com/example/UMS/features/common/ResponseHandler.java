package com.example.UMS.features.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("data", responseObj);

        return new ResponseEntity<>(map, status);
    }

    public static ResponseEntity<Object> successfulResponse() {
        return generateResponse("Success", HttpStatus.OK, null);
    }

    public static ResponseEntity<Object> unauthorizedResponse() {
        return generateResponse("Unauthorized", HttpStatus.UNAUTHORIZED, null);
    }

    public static ResponseEntity<Object> errorResponse() {
        return generateResponse("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR, null);
    }

    public static ResponseEntity<Object> badRequestResponse() {
        return generateResponse("Bad Request", HttpStatus.BAD_REQUEST, null);
    }
}
