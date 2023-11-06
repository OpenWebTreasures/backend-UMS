package com.example.UMS.exceptions;

import com.example.UMS.exceptions.errorobject.ErrorObject;
import com.example.UMS.exceptions.errorobject.ErrorObjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;
import java.util.Map;

@ControllerAdvice
@RequiredArgsConstructor
public class UMSExceptionHandler {

    private final ErrorObjectService errorObjectService;

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> test(RuntimeException ex) {
//        ErrorObject errorObject = new ErrorObject();
//        errorObject.setStatusCode(500);
//        errorObject.setMessage(ex.getMessage());
//        errorObjectService.create(errorObject);
        return Map.of("message", "Error have been occurred ! details was  ".concat(ex.getMessage()));
    }
}
