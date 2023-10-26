package com.example.UMS.features.user.dao;

import com.example.UMS.features.user.model.UserEntity;

import java.util.List;

public interface UserEntityDao {

    UserEntity create(UserEntity userEntity);

    UserEntity getUserById(Long id);

    List<UserEntity> findAll();

    void deleteById(Long id);

    boolean existsByUsername(String username);
}
