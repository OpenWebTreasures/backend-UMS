package com.example.UMS.features.role.service;

import com.example.UMS.features.role.dto.RoleDto;
import com.example.UMS.features.role.model.Role;

import java.util.List;

public interface RoleService {
    RoleDto createRole(RoleDto roleDto);

    RoleDto getRoleById(Long id);

    List<RoleDto> findAllRoles();

    boolean doesRoleExistByName(String name);

    RoleDto findRoleByName(String name);

    void addFeatureToRole(String roleName, String featureName);

    void revokeFeatureFromRole(String roleName, String featureName);

}
