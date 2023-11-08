package com.example.UMS.features.user.dto;

import com.example.UMS.features.common.Nationality;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CreateUserEntityDto extends UserEntityDto {
    private String password;
}
