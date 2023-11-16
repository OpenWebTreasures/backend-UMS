package com.example.UMS.features.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class CreateUserEntityDto extends UserEntityDto {
    private String password;
}
