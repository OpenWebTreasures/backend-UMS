package com.example.UMS.features.user.dao.impl;

import com.example.UMS.features.role.model.Role;
import com.example.UMS.features.role.repository.RoleRepository;
import com.example.UMS.features.user.dao.UserEntityDao;
import com.example.UMS.features.user.model.UserEntity;
import com.example.UMS.features.user.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserEntityDaoImpl implements UserEntityDao {

    private final UserEntityRepository userEntityRepository;
    private final RoleRepository roleRepository;

    @Override
    @SneakyThrows
    public UserEntity create(UserEntity userEntity) {
        return userEntityRepository.save(userEntity);
    }

    @Override
    public UserEntity getUserById(Long id) {
        return userEntityRepository.findById(id).orElse(null);
    }

    @Override
    public UserEntity getUserByUserName(String userName) {
        return userEntityRepository.findByUsername(userName).orElse(null);
    }

    @Override
    public List<UserEntity> findAll() {
        return userEntityRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        userEntityRepository.deleteById(id);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userEntityRepository.existsByUsername(username);
    }

    public void updatePassword(String username, String newPassword) {
        UserEntity userEntity = userEntityRepository.findByUsername(username).orElse(null);
        if (userEntity != null) {
            userEntity.setPassword(newPassword);
            userEntityRepository.save(userEntity);
        }
    }

    @Override
    public void updateRoles(String username, List<String> rolesNames) {
        UserEntity userEntity = userEntityRepository.findByUsername(username).orElse(null);
        if (userEntity != null) {
            List<Role> roles = roleRepository.findByNames(rolesNames);

            // Filter out null roles in case a roleName doesn't exist in the database
            roles = roles.stream().filter(Objects::nonNull).collect(Collectors.toList());

            userEntity.setRoles(roles);
            userEntityRepository.save(userEntity);
        }
    }

    @Override
    public void updateUser(UserEntity userEntity) {
        userEntityRepository.save(userEntity);
    }

    @Override
    public int countUsers() {
        Long resLong = userEntityRepository.count();
        return resLong.intValue();
    }

}
