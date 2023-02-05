package com.example.studentmanagement.service.custom;

import com.example.studentmanagement.dto.StudentDTO;
import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.service.SuperService;

import java.util.List;

public interface StudentService extends SuperService {
    void createNewStudentAccount(StudentDTO studentDTO);
    StudentDTO getStudentAccountDetails(Long studentId);
    void updateStudentDetails(StudentDTO studentDTO);
    void deleteStudent(Long studentId);

    List<Student> getStudentBySchool(Integer id);
}
