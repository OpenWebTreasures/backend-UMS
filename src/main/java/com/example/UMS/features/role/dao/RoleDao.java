package com.example.UMS.features.role.dao;

import com.example.UMS.features.role.model.Role;

import java.util.List;

public interface RoleDao {
    Role create(Role role);

    Role getRoleById(Long id);

    List<Role> findAll();

    boolean existsByName(String name);

    Role findByName(String name);

    List<Role> findRolesByNames(List<String> roleNames);

    Role update(Role role);
}
