package com.example.UMS.features.role.service.impl;

import com.example.UMS.features.role.dao.RoleDao;
import com.example.UMS.features.role.dto.RoleDto;
import com.example.UMS.features.role.mapper.RoleMapper;
import com.example.UMS.features.role.model.Feature;
import com.example.UMS.features.role.model.Role;
import com.example.UMS.features.role.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;
    private final RoleMapper roleMapper;

    @Override
    public RoleDto createRole(RoleDto roleDto) {
        return roleMapper.toDto(roleDao.create(roleMapper.toEntity(roleDto)));
    }

    @Override
    public RoleDto getRoleById(Long id) {
        return roleMapper.toDto(roleDao.getRoleById(id));
    }

    @Override
    public List<RoleDto> findAllRoles() {
        return roleMapper.toDtos(roleDao.findAll());
    }

    @Override
    public boolean doesRoleExistByName(String name) {
        return roleDao.existsByName(name);
    }

    @Override
    public RoleDto findRoleByName(String name) {
        return roleMapper.toDto(roleDao.findByName(name));
    }


    public void addFeatureToRole(String roleName, String featureName) {
        Role role = roleDao.findByName(roleName);
        if (role != null) {
            role.addFeature(Feature.valueOf(featureName));
            roleDao.update(role);
        }
    }

    public void revokeFeatureFromRole(String roleName, String featureName) {

        Role role = roleDao.findByName(roleName);
        if (role != null) {
            role.revokeFeature(Feature.valueOf(featureName));
            roleDao.update(role);
        }
    }
}
