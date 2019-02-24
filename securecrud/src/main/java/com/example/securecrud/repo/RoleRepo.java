package com.example.securecrud.repo;

import com.example.securecrud.entity.Role;
import com.example.securecrud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

}
