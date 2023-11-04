package com.example.UMS.features.user.mappers;

import com.example.UMS.features.user.dto.UserEntityDto;
import com.example.UMS.features.user.model.UserEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class UserMapper {

    protected final ModelMapper modelMapper;

    public UserEntity toEntity(UserEntityDto userEntityDto) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        UserEntity user = modelMapper.map(userEntityDto, UserEntity.class);
        return user;
    }

    public UserEntityDto toDto(UserEntity userEntity) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        UserEntityDto userEntityDto = modelMapper.map(userEntity, UserEntityDto.class);
        return userEntityDto;
    }
}
