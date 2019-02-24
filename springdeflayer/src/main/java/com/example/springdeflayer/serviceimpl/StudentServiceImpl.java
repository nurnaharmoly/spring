package com.example.springdeflayer.serviceimpl;

import com.example.springdeflayer.dto.StudentDTO;
import com.example.springdeflayer.entity.Student;
import com.example.springdeflayer.repository.StudentRepository;
import com.example.springdeflayer.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public void saveOrUpdate(StudentDTO studentDTO) {
            repository.save(convertDTOToEntity(studentDTO));
    }

    @Override
    public void deleteById(Long id) {
          repository.deleteById(id);
    }

    @Override
    public Student findById(Long id) {
        return repository.getOne(id);
    }

    @Override
    public Student findByEmailAddress(String email) {
        return repository.findByEmail(email);
    }


    @Override
    public List<StudentDTO> getAll() {
        List<StudentDTO> dtos = new ArrayList<>();
        List<Student> list = repository.findAll();
        for(Student s: list){
            dtos.add(convertEntityToDto(s));
        }
        return dtos;
    }

    @Override
    public long countNoOfStudent(String email) {
        return repository.countAllByEmail(email);
    }

    public Student convertDTOToEntity(StudentDTO dto){
        Student student = new Student();
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        return student;
        }


        public StudentDTO convertEntityToDto(Student student){
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        return dto;
        }

}
