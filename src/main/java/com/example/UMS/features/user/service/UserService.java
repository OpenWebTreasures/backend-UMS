package com.example.UMS.features.user.service;

import com.example.UMS.features.user.dto.UserEntityDto;
import com.example.UMS.features.user.model.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity create(UserEntityDto userEntityDto);

    UserEntity getUserById(Long id);

    List<UserEntity> findAll();

    void deleteById(Long id);

    boolean existsByUsername(String username);

    void initializeSuperAdminUser();
}
