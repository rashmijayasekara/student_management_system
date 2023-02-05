package com.example.studentmanagement.service.custom.impl;

import com.example.studentmanagement.dto.StudentDTO;
import com.example.studentmanagement.entity.School;
import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.repository.StudentRepository;
import com.example.studentmanagement.service.custom.StudentService;
import com.example.studentmanagement.util.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.AuthenticationException;
import java.util.List;

@Transactional
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final Transformer transformer;

    public StudentServiceImpl(StudentRepository studentRepository, Transformer transformer) {
        this.studentRepository = studentRepository;
        this.transformer = transformer;
    }

    public List<Student> findStudentsBySchool(School school){
        return null;
    }

    @Override
    public void createNewStudentAccount(StudentDTO studentDTO) {
//        studentRepository.save(studentDTO)
        studentRepository.save(transformer.toStudent(studentDTO));
    }

    @Override
    public StudentDTO getStudentAccountDetails(Long studentId) {
//        if (null!=studentId){
//            return studentRepository.findById(studentId);
//
//        }else {
//            return studentRepository.findAll();
//        }
        StudentDTO studentDTO = studentRepository.findById(studentId).map(transformer::toStudentDTO).get();
        return studentDTO;


    }

    @Override
    public void updateStudentDetails(StudentDTO studentDTO) {
        studentRepository.save(transformer.toStudent(studentDTO));

    }

    @Override
    public void deleteStudent(Long studentId) {
//        studentRepository.delete();
        studentRepository.deleteById(studentId);
    }

    @Override
    public void getStudentBySchool(Integer id) {

    }
}
