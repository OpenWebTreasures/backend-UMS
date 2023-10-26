package com.example.UMS.features.role.service;

import com.example.UMS.features.role.model.Role;

import java.util.List;

public interface RoleService {
    Role createRole(Role role);

    Role getRoleById(Long id);

    List<Role> findAllRoles();

    boolean doesRoleExistByName(String name);

    Role findRoleByName(String name);

    List<Role> findRolesByNames(List<String> roleNames);
}
