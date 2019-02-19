package com.example.loginmysql.repo;

import com.example.loginmysql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUserNameOrEmail(String userName, String email);
    User findByUserName(String userName);
}
