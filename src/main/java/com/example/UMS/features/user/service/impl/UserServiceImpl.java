package com.example.UMS.features.user.service.impl;

import com.example.UMS.features.role.dao.RoleDao;
import com.example.UMS.features.role.model.Role;
import com.example.UMS.features.user.dao.UserEntityDao;
import com.example.UMS.features.user.dto.UserEntityDto;
import com.example.UMS.features.user.model.UserEntity;
import com.example.UMS.features.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserEntityDao userDao;
    private final RoleDao roleDao;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserEntity create(UserEntityDto userEntityDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userEntityDto.getUsername());
        userEntity.setPassword(passwordEncoder.encode(userEntityDto.getPassword()));

        List<Role> roles = roleDao.findRolesByNames(userEntityDto.getRoleNames());
        userEntity.setRoles(roles);
        return userDao.create(userEntity);
    }

    @Override
    public UserEntity getUserById(Long id) {
        return userDao.getUserById(id);
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

    @Override
    @Transactional
    public void initializeSuperAdminUser() {
        String superAdminUsername = "superadmin";
        String superAdminPassword = "superadmin";
        String superAdminRoleName = "SUPERADMIN";

        // Check if the super admin user exists, and create it if not
        if (!existsByUsername(superAdminUsername)) {
            UserEntityDto superAdminUser = new UserEntityDto();
            superAdminUser.setUsername(superAdminUsername);
            superAdminUser.setPassword(superAdminPassword);
            List<String> roles = new ArrayList<>();
            roles.add(superAdminRoleName);
            superAdminUser.setRoleNames(roles);
            create(superAdminUser);
        }
    }
}
