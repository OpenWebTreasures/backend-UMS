package com.example.UMS.features.role.service.impl;

import com.example.UMS.features.role.dao.RoleDao;
import com.example.UMS.features.role.model.Role;
import com.example.UMS.features.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role createRole(Role role) {
        return roleDao.create(role);
    }

    @Override
    public Role getRoleById(Long id) {
        return roleDao.getRoleById(id);
    }

    @Override
    public List<Role> findAllRoles() {
        return roleDao.findAll();
    }

    @Override
    public boolean doesRoleExistByName(String name) {
        return roleDao.existsByName(name);
    }

    @Override
    public Role findRoleByName(String name) {
        return roleDao.findByName(name);
    }

    public List<Role> findRolesByNames(List<String> roleNames) {
        return roleDao.findRolesByNames(roleNames);
    }

    @Override
    @Transactional
    public void initializeSuperAdminRole() {
        String superAdminRoleName = "SUPERADMIN";
        if (!doesRoleExistByName(superAdminRoleName)) {
            Role superAdminRole = new Role();
            superAdminRole.setName(superAdminRoleName);
            createRole(superAdminRole);
        }
    }

}
