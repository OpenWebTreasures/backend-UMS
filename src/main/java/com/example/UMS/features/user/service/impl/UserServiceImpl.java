package com.example.UMS.features.user.service.impl;

import com.example.UMS.features.user.dao.UserEntityDao;
import com.example.UMS.features.user.dto.*;
import com.example.UMS.features.user.mappers.UserMapper;
import com.example.UMS.features.user.model.UserEntity;
import com.example.UMS.features.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserEntityDao userDao;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;


    @Override
    public UserEntityDto create(CreateUserEntityDto createUserEntityDto) {
        log.info("Service create UserEntity called details:" + createUserEntityDto.toString());
        UserEntity userEntity = userMapper.toEntity(createUserEntityDto);
        userEntity.setPassword(passwordEncoder.encode(createUserEntityDto.getPassword()));
        return userMapper.toDto(userDao.create(userEntity));
    }

    @Override
    public UserEntityDto getUserById(Long id) {
        return userMapper.toDto(userDao.getUserById(id));
    }

    @Override
    public UserEntityDto getUserByUserName(String userName) {
        return userMapper.toDto(userDao.getUserByUserName(userName));
    }

    @Override
    public List<UserEntityDto> findAll() {
        return userMapper.toDtos(userDao.findAll());
    }

    @Override
    public void deleteById(Long id) {
        log.warn("Service Delete UserEntity called");
        userDao.deleteById(id);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userDao.existsByUsername(username);
    }

    @Override
    public UserEntityDto getConnectedUserDetails(String username) {
        UserEntity userEntity = userDao.getUserByUserName(username);
        userEntity.setPassword("");
        return userMapper.toDto(userEntity);
    }

    @Override
    public void changeUserPassword(ChangeUserPasswordDto changeUserPasswordDto) {
        userDao.updatePassword(changeUserPasswordDto.getUsername(), passwordEncoder.encode(changeUserPasswordDto.getPassword()));
    }

    @Override
    public void updateRoles(ChangeUserRolesDto changeUserRolesDto) {
        log.warn(String.format("Service update Roles for user: %s", changeUserRolesDto.getUsername()));
        userDao.updateRoles(changeUserRolesDto.getUsername(), changeUserRolesDto.getRoleNames());
    }

    @Override
    public void updateUserDetails(String username, ChangeUserDetailsDto changeUserDetailsDto) {
        UserEntity userEntity = userDao.getUserByUserName(username);
        userEntity.setUsername(changeUserDetailsDto.getUsername());
        userEntity.setFirstname(changeUserDetailsDto.getFirstname());
        userEntity.setLastname(changeUserDetailsDto.getLastname());
        userEntity.setEmail(changeUserDetailsDto.getEmail());
        userEntity.setDatenaissance(changeUserDetailsDto.getDatenaissance());
        userEntity.setNationality(changeUserDetailsDto.getNationality());
        userEntity.setAdress(changeUserDetailsDto.getAdress());
        userDao.updateUser(userEntity);
    }

}
