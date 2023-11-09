package com.example.UMS.features.user.dto;

import com.example.UMS.features.common.Nationality;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChangeUserDetailsDto {
    private String firstname;
    private String lastname;
    private String email;
    private Date datenaissance;
    private Nationality nationality;
    private String adress;
    private String username;
}
