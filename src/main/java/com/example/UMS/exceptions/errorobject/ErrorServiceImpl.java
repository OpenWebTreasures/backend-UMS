package com.example.UMS.exceptions.errorobject;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ErrorServiceImpl implements ErrorObjectService {

    private final ErrorObjectRepository errorObjectRepository;

    @Override
    public ErrorObject create(ErrorObject errorObject) {
        return errorObjectRepository.save(errorObject);
    }

    @Override
    public List<ErrorObject> findAll() {
        return errorObjectRepository.findAll();
    }
}
