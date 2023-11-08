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
    private Date datenaissance;
    private Nationality nationality;
    private String adress;
    private String username;
    private List<String> roleNames;
}
