package com.example.springdeflayer.repository;

import com.example.springdeflayer.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByEmail(String email);
    long countAllByEmail(String email);
}
