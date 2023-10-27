package com.example.UMS.features.user.dao.impl;

import com.example.UMS.features.user.dao.UserEntityDao;
import com.example.UMS.features.user.model.UserEntity;
import com.example.UMS.features.user.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserEntityDaoImpl implements UserEntityDao {

    private final UserEntityRepository userEntityRepository;

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

}
