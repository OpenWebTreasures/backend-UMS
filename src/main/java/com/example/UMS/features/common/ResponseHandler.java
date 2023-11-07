package com.example.UMS.features.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static <T> ResponseEntity<Map<String, Object>> generateResponse(String message, HttpStatus status, T responseObj) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("data", responseObj);

        return new ResponseEntity<>(map, status);
    }

    public static <T> ResponseEntity<T> successfulResponse(T responseObj) {
        return (ResponseEntity<T>) generateResponse("Success", HttpStatus.OK, responseObj);
    }

    public static ResponseEntity<Object> successfulResponse() {
        return successfulResponse(null);
    }

    public static ResponseEntity<Map<String, Object>> unauthorizedResponse() {
        return generateResponse("Unauthorized", HttpStatus.UNAUTHORIZED, null);
    }

    public static ResponseEntity<Map<String, Object>> errorResponse() {
        return generateResponse("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR, null);
    }

    public static ResponseEntity<Map<String, Object>> badRequestResponse() {
        return generateResponse("Bad Request", HttpStatus.BAD_REQUEST, null);
    }
}
