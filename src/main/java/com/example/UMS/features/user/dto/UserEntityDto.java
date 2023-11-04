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
public class UserEntityDto {
    private String firstname;
    private String lastname;
    private String email;
    private Date date;
    private Nationality nationality;
    private String adress;
    private String username;
    private String password;
    private List<String> roleNames; // This field will hold the role names.
}
