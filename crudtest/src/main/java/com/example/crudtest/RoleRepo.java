package com.example.crudtest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByRoleName(String roleName);
}
