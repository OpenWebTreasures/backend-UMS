package com.example.UMS;

import com.example.UMS.features.role.model.Role;
import com.example.UMS.features.role.repository.RoleRepository;
import com.example.UMS.features.role.service.RoleService;
import com.example.UMS.features.user.model.UserEntity;
import com.example.UMS.features.user.repository.UserEntityRepository;
import com.example.UMS.features.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class UmsApplication {

    private final UserService userService;
    private final RoleService roleService;

    public static void main(String[] args) {
        SpringApplication.run(UmsApplication.class, args);
    }

    @PostConstruct
    public void initializeSuperAdmin() {
        roleService.initializeSuperAdminRole();
        userService.initializeSuperAdminUser();
    }

}
