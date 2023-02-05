package com.example.studentmanagement.repository;

import com.example.studentmanagement.entity.School;
import com.example.studentmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query(value = "select s from Student s where s.schoolId=?1")
    List<Student> findAllStudentsBySchool(School SchoolId);

}
