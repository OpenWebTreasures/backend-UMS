package com.example.UMS.features.role.service.impl;

import com.example.UMS.features.role.dao.RoleDao;
import com.example.UMS.features.role.model.Feature;
import com.example.UMS.features.role.model.Role;
import com.example.UMS.features.role.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;


    @Override
    @Transactional
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



    public void addFeatureToRole(String roleName, String featureName) {
//        Role role = roleDao.findByName(roleName);
//        if (role != null) {
//            Feature feature = Feature.(featureName);
//            if (feature != null) {
//                role.addFeature(feature);
//                roleDao.update(role);
//            }
//        }
    }

    public void revokeFeatureFromRole(String roleName, String featureName) {
//        Role role = roleDao.findByName(roleName);
//        if (role != null) {
//            Feature feature = featureDao.findByName(featureName);
//            if (feature != null) {
//                role.revokeFeature(feature);
//                roleDao.update(role);
//            }
//        }
    }

}
