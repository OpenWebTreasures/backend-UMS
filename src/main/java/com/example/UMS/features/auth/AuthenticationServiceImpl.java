package com.example.UMS.features.auth;

import com.example.UMS.features.auth.payload.RegisterRequest;
import com.example.UMS.features.auth.payload.AuthenticationRequest;
import com.example.UMS.features.auth.payload.AuthenticationResponse;
import com.example.UMS.features.role.dao.RoleDao;
import com.example.UMS.features.role.model.Role;
import com.example.UMS.features.user.dao.UserEntityDao;
import com.example.UMS.features.user.model.UserEntity;
import com.example.UMS.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final RoleDao roleDao;
    private final UserEntityDao userEntityDao;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;


    @Override
    public AuthenticationResponse register(RegisterRequest registerRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstname(registerRequest.getFirstname());
        userEntity.setLastname(registerRequest.getLastname());
        userEntity.setEmail(registerRequest.getEmail());
        userEntity.setBirthDate(registerRequest.getBirthDate());
        userEntity.setNationality(registerRequest.getNationality());
        userEntity.setAddress(registerRequest.getAddress());
        userEntity.setUsername(registerRequest.getUsername());
        userEntity.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        Role role = roleDao.findByName("USER");
        userEntity.setRoles(List.of(role));

        UserEntity user = userEntityDao.create(userEntity);
        String jwt = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .roles(List.of(role.getName()))
                .tokenType("BEARER")
                .accessToken(jwt)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        UserEntity user = userEntityDao.getUserByUserName(request.getUsername());
        if (user == null)
            throw new IllegalArgumentException("Invalid email or password.");
        String jwt = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .roles(user.getRoles().stream().map(role -> role.getName()).collect(Collectors.toList()))
                .tokenType("BEARER")
                .accessToken(jwt)
                .build();
    }

}
