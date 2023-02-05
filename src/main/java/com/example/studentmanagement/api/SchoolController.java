package com.example.studentmanagement.api;

import com.example.studentmanagement.dto.SchoolDTO;
import com.example.studentmanagement.service.custom.SchoolService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/school")
public class SchoolController {
    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = "application/json")
    public SchoolDTO createSchoolDTO(@RequestBody SchoolDTO schoolDTO){
       return schoolService.createNewSchool(schoolDTO);

    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(consumes = "application/json")
    public void updateSchoolDetails(@RequestBody SchoolDTO schoolDTO){
        schoolService.updateSchoolDetails(schoolDTO);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{schoolId}")
    public void deleteTask(@PathVariable("schoolId") int schoolId){
        System.out.println(schoolId);
        schoolService.deleteSchool(schoolId);
    }

    @GetMapping(value = "/{schoolId}",produces = "application/json")
    public SchoolDTO getSchoolDetails(@PathVariable("schoolId") Integer schoolId){
      return schoolService.getSchoolDetails(schoolId);
    }

    @GetMapping(value = "/all")
    public List<SchoolDTO> getAllSchools(){
        return schoolService.getAllSchools();
    }

}
