package com.example.springdeflayer.service;

import com.example.springdeflayer.dto.StudentDTO;
import com.example.springdeflayer.entity.Student;

import java.util.List;

public interface StudentService {

    void saveOrUpdate(StudentDTO studentDTO);

    void  deleteById(Long id);

    Student findById(Long id);

    Student findByEmailAddress(String email);

    List<StudentDTO> getAll();

    long countNoOfStudent(String email);


}
