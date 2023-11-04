package com.example.UMS.features.common;

import com.example.UMS.features.role.model.Role;
import com.example.UMS.features.role.service.RoleService;
import com.example.UMS.features.user.dto.UserEntityDto;
import com.example.UMS.features.user.model.UserEntity;
import com.example.UMS.features.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class Initializer {
    private final RoleService roleService;
    private final UserService userService;

    @PostConstruct
    public void startInitializer() {
        createSuperAdminRole();
        createSuperAdminUser();
    }

    private void createSuperAdminRole() {
        String superAdminRoleName = "SUPERADMIN";
        if (!roleService.doesRoleExistByName(superAdminRoleName)) {
            roleService.createRole(new Role(superAdminRoleName));
        }
    }

    @SneakyThrows
    private void createSuperAdminUser() {
        String superAdminUsername = "superadmin";
        String superAdminPassword = "superadmin";

        if (!userService.existsByUsername(superAdminUsername)) {
            UserEntityDto superAdminUser = new UserEntityDto();
            superAdminUser.setUsername(superAdminUsername);
            superAdminUser.setPassword(superAdminPassword);
            superAdminUser.setFirstname("Mazen");
            superAdminUser.setLastname("Hadj Ali");
            superAdminUser.setNationality(Nationality.Tunisian);
            superAdminUser.setEmail("hadjalimazen@gmail.com");
            superAdminUser.setAdress("Bennane, Monastir, Tunisia");
            superAdminUser.setDate(new Date());
            List<String> roles = new ArrayList<>();
            roles.add("SUPERADMIN");
            superAdminUser.setRoleNames(roles);

            // Use create method or another suitable method
            UserEntity u = userService.create(superAdminUser);
            System.out.println(u.getId());
        }
    }
}