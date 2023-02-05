package com.example.studentmanagement.service.custom.impl;

import com.example.studentmanagement.dto.StudentDTO;
import com.example.studentmanagement.entity.School;
import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.repository.SchoolRepository;
import com.example.studentmanagement.repository.StudentRepository;
import com.example.studentmanagement.service.custom.StudentService;
import com.example.studentmanagement.util.Transformer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final SchoolRepository schoolRepository;

    private final Transformer transformer;

    public StudentServiceImpl(StudentRepository studentRepository, SchoolRepository schoolRepository, Transformer transformer) {
        this.studentRepository = studentRepository;
        this.schoolRepository = schoolRepository;
        this.transformer = transformer;
    }


    @Override
    public void createNewStudentAccount(StudentDTO studentDTO) {
        studentRepository.save(transformer.toStudent(studentDTO));
    }

    @Override
    public StudentDTO getStudentAccountDetails(Long studentId) {
        StudentDTO studentDTO = studentRepository.findById(studentId).map(transformer::toStudentDTO).get();
        return studentDTO;
    }

    @Override
    public void updateStudentDetails(StudentDTO studentDTO) {
        studentRepository.save(transformer.toStudent(studentDTO));
    }

    @Override
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public List<Student> getStudentBySchool(Integer id) {
        return studentRepository.findAllStudentsBySchool(schoolRepository.findById(id).orElseThrow());
    }
}
