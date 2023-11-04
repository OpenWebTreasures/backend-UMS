package com.example.UMS.features.user.service.impl;

import com.example.UMS.features.common.Nationality;
import com.example.UMS.features.role.dao.RoleDao;
import com.example.UMS.features.role.model.Role;
import com.example.UMS.features.user.dao.UserEntityDao;
import com.example.UMS.features.user.dto.UserEntityDto;
import com.example.UMS.features.user.mappers.UserMapper;
import com.example.UMS.features.user.model.UserEntity;
import com.example.UMS.features.user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserEntityDao userDao;
    private final RoleDao roleDao;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;


    @Override
    public UserEntity create(UserEntityDto userEntityDto) {
        UserEntity userEntity = userMapper.toEntity(userEntityDto);
        List<Role> roles = roleDao.findRolesByNames(userEntityDto.getRoleNames());
        userEntity.setRoles(roles);
        userEntity.setPassword(passwordEncoder.encode(userEntityDto.getPassword()));
        return userDao.create(userEntity);
    }

    @Override
    public UserEntity getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public UserEntity getUserByUserName(String userName) {
        return userDao.getUserByUserName(userName);
    }

    @Override
    public List<UserEntity> findAll() {
        return userDao.findAll();
    }

    @Override
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userDao.existsByUsername(username);
    }

}
