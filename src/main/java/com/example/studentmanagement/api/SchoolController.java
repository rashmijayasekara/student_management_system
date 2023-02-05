package com.example.studentmanagement.api;

import com.example.studentmanagement.dto.SchoolDTO;
import com.example.studentmanagement.service.custom.SchoolService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/school")
public class SchoolController {
    private SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = "application/json")
    public SchoolDTO createSchoolDTO(@RequestBody SchoolDTO schoolDTO){
       return schoolService.createNewSchool(schoolDTO);

    }
    public void updateSchoolDetails(){

    }
    public void deleteTask(){

    }
    public SchoolDTO getSchoolDetails(){
        return null;
    }

    public List<SchoolDTO> getAllSchools(){
        return null;
    }

}
