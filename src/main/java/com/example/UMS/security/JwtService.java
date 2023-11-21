package com.example.UMS.security;

import com.example.UMS.features.user.model.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;


public interface JwtService {
    String extractUserName(String token);

    String generateToken(UserEntity userEntity);

    boolean isTokenValid(String token, UserDetails userDetails);
}
