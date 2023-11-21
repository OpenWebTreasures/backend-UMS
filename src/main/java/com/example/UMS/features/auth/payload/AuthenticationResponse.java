package com.example.UMS.features.auth.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {
    private  Long id;
    private String username;
    private String firstname;
    private String lastname;
    private List<String> roles;
    private String accessToken;
    private String tokenType;
}
