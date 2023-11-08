package com.example.UMS.features.user.service;

import com.example.UMS.features.user.dto.CreateUserEntityDto;
import com.example.UMS.features.user.dto.UserEntityDto;
import com.example.UMS.features.user.model.UserEntity;

import java.util.List;

public interface UserService {
    UserEntityDto create(CreateUserEntityDto createUserEntityDto);

    UserEntityDto getUserById(Long id);

    UserEntityDto getUserByUserName(String userName);

    List<UserEntityDto> findAll();

    void deleteById(Long id);

    boolean existsByUsername(String username);

    UserEntityDto getConnectedUserDetails(String username);

}
