package com.example.UMS.features.user.mappers;

import com.example.UMS.features.role.dao.RoleDao;
import com.example.UMS.features.role.model.Role;
import com.example.UMS.features.user.dao.UserEntityDao;
import com.example.UMS.features.user.dto.UserEntityDto;
import com.example.UMS.features.user.model.UserEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class UserMapper {

    protected final ModelMapper modelMapper;
    protected final RoleDao roleDao;


    public UserEntity toEntity(UserEntityDto userEntityDto) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        UserEntity user = modelMapper.map(userEntityDto, UserEntity.class);

        user.setRoles(userEntityDto.getRoleNames().stream()
                .map(roleName -> roleDao.findByName(roleName))
                .collect(Collectors.toList()));
        return user;
    }

    public UserEntityDto toDto(UserEntity userEntity) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        UserEntityDto userEntityDto = modelMapper.map(userEntity, UserEntityDto.class);
        userEntityDto.setRoleNames(userEntity.getRoles().stream()
                .map(Role::getName)
                .collect(Collectors.toList()));
        return userEntityDto;
    }
}
