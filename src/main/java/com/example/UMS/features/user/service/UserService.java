package com.example.UMS.features.user.service;

import com.example.UMS.features.user.dto.*;
import com.example.UMS.features.user.model.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService {
    UserEntityDto create(CreateUserEntityDto createUserEntityDto);

    UserEntityDto getUserById(Long id);

    UserEntityDto getUserByUserName(String userName);

    List<UserEntityDto> findAll();

    int countUsers();

    void deleteById(Long id);

    boolean existsByUsername(String username);

    UserEntityDto getConnectedUserDetails(String username);

    void changeUserPassword(ChangeUserPasswordDto changeUserPasswordDto);
    void changeSelfPassword(ChangeSelfPasswordDto changeSelfPasswordDto);

    void updateRoles(ChangeUserRolesDto changeUserRolesDto);

    void updateUserDetails(String username, ChangeUserDetailsDto changeUserDetailsDto);
}
