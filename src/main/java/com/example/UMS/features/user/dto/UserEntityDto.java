package com.example.UMS.features.user.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserEntityDto {
    private String username;
    private String password;
    private List<String> roleNames; // This field will hold the role names.
}
