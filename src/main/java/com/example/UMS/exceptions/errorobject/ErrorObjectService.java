package com.example.UMS.exceptions.errorobject;

import java.util.List;

public interface ErrorObjectService {

    ErrorObject create(ErrorObject errorObject);

    List<ErrorObject> findAll();
}
