package com.example.UMS.features.role.controller;

import com.example.UMS.features.role.dto.FeatureRoleDto;
import com.example.UMS.features.role.model.Role;
import com.example.UMS.features.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/roles")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public Role createRole(@RequestBody Role role) {
        return roleService.createRole(role);
    }

    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable Long id) {
        return roleService.getRoleById(id);
    }

    @GetMapping
    public List<Role> findAllRoles() {
        return roleService.findAllRoles();
    }

    @GetMapping("/exists/{name}")
    public boolean doesRoleExistByName(@PathVariable String name) {
        return roleService.doesRoleExistByName(name);
    }

    @GetMapping("/find/{name}")
    public Role findRoleByName(@PathVariable String name) {
        return roleService.findRoleByName(name);
    }

    @PostMapping("/assignfeature")
    public ResponseEntity<String> addFeatureToRole(@RequestBody FeatureRoleDto featureRoleDto) {
        roleService.addFeatureToRole(featureRoleDto.getRoleName(), featureRoleDto.getFeatureName());
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/revokefeature")
    public ResponseEntity<String> revokeFeatureFromRole(@RequestBody FeatureRoleDto featureRoleDto) {
        roleService.revokeFeatureFromRole(featureRoleDto.getRoleName(), featureRoleDto.getFeatureName());
        return ResponseEntity.ok("ok");
    }
}
