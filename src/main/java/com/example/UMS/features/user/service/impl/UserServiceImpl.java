package com.example.UMS.features.user.service.impl;

import com.example.UMS.features.user.dao.UserEntityDao;
import com.example.UMS.features.user.dto.CreateUserEntityDto;
import com.example.UMS.features.user.dto.UserEntityDto;
import com.example.UMS.features.user.mappers.UserMapper;
import com.example.UMS.features.user.model.UserEntity;
import com.example.UMS.features.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserEntityDao userDao;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;


    @Override
    public UserEntityDto create(CreateUserEntityDto createUserEntityDto) {
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

}
