package com.example.studentmanagement.api;

import com.example.studentmanagement.dto.StudentDTO;
import com.example.studentmanagement.entity.School;
import com.example.studentmanagement.entity.SportsClub;
import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.service.custom.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes ="application/json")
    public void saveStudent(@RequestBody StudentDTO studentDTO){
        System.out.println("Hi inside save student");

//        studentService.createNewStudentAccount(studentDTO);
       studentService.createNewStudentAccount(studentDTO);
    }


    @GetMapping(value = "/find/{id}",produces = "application/json")
    public StudentDTO getStudentByID(@PathVariable("id") Long studentId){
//        return studentService.getStudentAccountDetails(studentId);
        System.out.println(studentId);
        return studentService.getStudentAccountDetails(studentId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable("id") Long studentId){
        System.out.println(studentId);
        studentService.deleteStudent(studentId);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(value = "/update/{id}",consumes = "application/json")
    public void updateStudentDetails(@RequestBody StudentDTO studentDTO, @PathVariable("id") Long studentId){
        System.out.println(studentDTO.toString());
        System.out.println(studentId);
        studentService.updateStudentDetails(studentDTO);
    }

    @GetMapping("/all")
    public List<StudentDTO> getAllStudents(){
        System.out.println("Inside getAll");
        return null;
    }






    public List<Student> findStudentsBySchool(School school){
//        studentService.getStudentAccountDetails(4);
        return null;
    }


}
