package com.example.UMS.features.user.mappers;

import com.example.UMS.features.role.dao.RoleDao;
import com.example.UMS.features.role.model.Role;
import com.example.UMS.features.user.dao.UserEntityDao;
import com.example.UMS.features.user.dto.UserEntityDto;
import com.example.UMS.features.user.model.UserEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    protected final ModelMapper modelMapper;
    protected final RoleDao roleDao;

    public UserMapper(ModelMapper modelMapper, RoleDao roleDao) {
        this.modelMapper = modelMapper;
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        this.roleDao = roleDao;
    }

    public UserEntity toEntity(UserEntityDto userEntityDto) {
        UserEntity user = modelMapper.map(userEntityDto, UserEntity.class);

        user.setRoles(userEntityDto.getRoleNames().stream()
                .map(roleName -> roleDao.findByName(roleName))
                .collect(Collectors.toList()));
        return user;
    }

    public UserEntityDto toDto(UserEntity userEntity) {
        UserEntityDto userEntityDto = modelMapper.map(userEntity, UserEntityDto.class);
        userEntityDto.setRoleNames(userEntity.getRoles().stream()
                .map(Role::getName)
                .collect(Collectors.toList()));
        return userEntityDto;
    }

    public List<UserEntity> toEntities(List<UserEntityDto> userEntityDtos) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return userEntityDtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    public List<UserEntityDto> toDtos(List<UserEntity> userEntities) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return userEntities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
