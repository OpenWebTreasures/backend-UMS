package com.example.UMS.features.user.dao;

import com.example.UMS.features.user.model.UserEntity;

import java.util.List;

public interface UserEntityDao {

    UserEntity create(UserEntity userEntity);

    UserEntity getUserById(Long id);

    UserEntity getUserByUserName(String userName);

    List<UserEntity> findAll();

    void deleteById(Long id);

    boolean existsByUsername(String username);

    void updatePassword(String username, String newPassword);

    void updateRoles(String username, List<String> rolesNames);

    void updateUser(UserEntity userEntity);
}
