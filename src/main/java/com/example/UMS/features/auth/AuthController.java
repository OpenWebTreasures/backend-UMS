package com.example.UMS.features.auth;

import com.example.UMS.features.auth.dto.AuthResponseDTO;
import com.example.UMS.features.auth.dto.LoginDto;
import com.example.UMS.features.auth.dto.RegisterDto;
import com.example.UMS.features.role.model.Role;
import com.example.UMS.features.role.repository.RoleRepository;
import com.example.UMS.features.role.service.RoleService;
import com.example.UMS.features.user.dto.UserEntityDto;
import com.example.UMS.features.user.repository.UserEntityRepository;
import com.example.UMS.features.user.service.UserService;
import com.example.UMS.security.JWTGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;
    private final JWTGenerator jwtGenerator;


    @PostMapping("login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(),
                        loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }


    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        if (userService.existsByUsername(registerDto.getUsername())) {
            return new ResponseEntity<>("Username is taken!", HttpStatus.BAD_REQUEST);
        }

        UserEntityDto userEntityDto = new UserEntityDto();
        userEntityDto.setUsername(registerDto.getUsername());
        userEntityDto.setPassword(passwordEncoder.encode((registerDto.getPassword())));

        Role roles = roleService.findRoleByName("user");
        userEntityDto.setRoleNames(Collections.singletonList(roles.getName()));

        userService.create(userEntityDto);

        return new ResponseEntity<>("UserEntity registered success!", HttpStatus.OK);
    }
}
