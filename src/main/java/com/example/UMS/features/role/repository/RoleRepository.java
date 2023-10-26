package com.example.UMS.features.role.repository;

import com.example.UMS.features.role.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    boolean existsByName(String name);

    Optional<Role> findByName(String name);

    @Query("SELECT r FROM Role r WHERE r.name IN :roleNames")
    List<Role> findByNames(@Param("roleNames") List<String> roleNames);

}
