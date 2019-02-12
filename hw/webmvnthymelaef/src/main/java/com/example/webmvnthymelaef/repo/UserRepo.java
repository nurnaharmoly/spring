package com.example.webmvnthymelaef.repo;

import com.example.webmvnthymelaef.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
