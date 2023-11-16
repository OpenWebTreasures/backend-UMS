package com.example.UMS.features.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class CreateUserEntityDto extends UserEntityDto {
    private String password;
}
