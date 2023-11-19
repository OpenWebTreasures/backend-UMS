package com.example.UMS.features.common;

import com.example.UMS.features.role.dto.RoleDto;
import com.example.UMS.features.role.model.Feature;
import com.example.UMS.features.role.service.RoleService;
import com.example.UMS.features.user.dto.CreateUserEntityDto;
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
        createUserRole();
        createSuperAdminUser();
    }

    private void createSuperAdminRole() {
        String superAdminRoleName = "SUPERADMIN";
        if (!roleService.doesRoleExistByName(superAdminRoleName)) {
            RoleDto superAdminRole = new RoleDto();
            superAdminRole.setName(superAdminRoleName);
            superAdminRole.setFeatures(Feature.getAllFeatures());
            roleService.createRole(superAdminRole);
        }
    }
    private void createUserRole() {
        String userRoleName = "USER";
        if (!roleService.doesRoleExistByName(userRoleName)) {
            RoleDto userRole = new RoleDto();
            userRole.setName(userRoleName);
            userRole.setFeatures(List.of(Feature.COUNT_USERS));
            roleService.createRole(userRole);
        }
    }

    @SneakyThrows
    private void createSuperAdminUser() {
        String superAdminUsername = "superadmin";
        String superAdminPassword = "superadmin";

        if (!userService.existsByUsername(superAdminUsername)) {
            CreateUserEntityDto superAdminUser = new CreateUserEntityDto();
            superAdminUser.setUsername(superAdminUsername);
            superAdminUser.setPassword(superAdminPassword);
            superAdminUser.setFirstname("Mazen");
            superAdminUser.setLastname("Hadj Ali");
            superAdminUser.setNationality(Nationality.Tunisian);
            superAdminUser.setEmail("hadjalimazen@gmail.com");
            superAdminUser.setAdress("Bennane, Monastir, Tunisia");
            superAdminUser.setDatenaissance(new Date());
            List<String> roles = new ArrayList<>();
            roles.add("SUPERADMIN");
            superAdminUser.setRoleNames(roles);


            // Use create method or another suitable method
            userService.create(superAdminUser);
        }
    }
}
