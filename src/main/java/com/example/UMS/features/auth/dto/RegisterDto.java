package com.example.UMS.features.auth.dto;

import com.example.UMS.features.common.Nationality;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
    private String firstname;
    private String lastname;
    private String email;
    private Date date;
    private Nationality nationality;
    private String adress;
    private String username;
    private String password;
}
