package com.example.UMS.features.user.dto;

import com.example.UMS.features.common.Nationality;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserEntityDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private Date datenaissance;
    private Nationality nationality;
    private String adress;
    private String username;
    private List<String> roleNames;
    private Instant createdOn;
    private Instant lastUpdatedOn;
}
