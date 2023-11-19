package com.example.UMS.features.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChangeSelfPasswordDto {
    private String username;
    private String currentPassword;
    private String password;
}
