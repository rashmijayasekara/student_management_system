package com.example.studentmanagement.api;

import com.example.studentmanagement.dto.StudentDTO;
import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.service.custom.StudentService;
import com.example.studentmanagement.util.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;
    private final Transformer transformer;

    @Autowired
    public StudentController(StudentService studentService, Transformer transformer) {
        this.studentService = studentService;
        this.transformer = transformer;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void saveStudent(@RequestParam("profileImage") MultipartFile multipartFile,@RequestParam("student") Student student) {
        studentService.createNewStudentAccount(transformer.toStudentDTO(student));
    }


    @GetMapping(value = "/find/{id}", produces = "application/json")
    public StudentDTO getStudentByID(@PathVariable("id") Long studentId) {
        System.out.println(studentId);
        return studentService.getStudentAccountDetails(studentId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable("id") Long studentId) {
        System.out.println(studentId);
        studentService.deleteStudent(studentId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(value = "/update/{id}", consumes = "application/json")
    public void updateStudentDetails(@RequestBody StudentDTO studentDTO, @PathVariable("id") Long studentId) {
        System.out.println(studentDTO.toString());
        System.out.println(studentId);
        studentService.updateStudentDetails(studentDTO);
    }

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }


    @GetMapping("/school/{id}")
    public List<Student> findStudentsBySchool(@PathVariable("id") Integer id) {
       return studentService.getStudentBySchool(id);
    }


}
