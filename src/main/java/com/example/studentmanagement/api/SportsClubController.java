package com.example.studentmanagement.api;

import com.example.studentmanagement.dto.SportsClubDTO;
import com.example.studentmanagement.dto.StudentDTO;
import com.example.studentmanagement.entity.School;
import com.example.studentmanagement.entity.SportsClub;
import com.example.studentmanagement.service.custom.SportsClubService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sportsclub")
public class SportsClubController {
    private SportsClubService sportsClubService;

    public SportsClubController(SportsClubService sportsClubService) {
        this.sportsClubService = sportsClubService;
    }

    @GetMapping
    public void doSomething(){
        System.out.println("Hii");

    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes ="application/json")
    public void saveSportsClub(@RequestBody SportsClubDTO sportsClubDTO){
//        studentService.createNewStudentAccount(studentDTO);
        System.out.println("Hi inside save student");
    }

    @GetMapping(value = "/find/{id}",produces = "application/json")
    public SportsClubDTO getSportsClubByID(@PathVariable("id") Integer sportsClubId){
//        return studentService.getStudentAccountDetails(studentId);
        System.out.println(sportsClubId);
        return null;
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public void deleteSportsClub(@PathVariable("id") Integer sportsclubId){
        System.out.println(sportsclubId);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(value = "/update/{id}",consumes = "application/json")
    public void updateSportsClubDetails(@RequestBody SportsClubDTO sportsClubDTO, @PathVariable("id") Integer sportsClubId){
        System.out.println(sportsClubDTO.toString());
        System.out.println(sportsClubId);
    }

    @GetMapping("/all")
    public List<SportsClubDTO> getAllSportsClubs(){
        System.out.println("Inside getAll");
        return null;
    }


    public List<School> findSchoolsBySportsClub(SportsClub sportsClub){
        return null;
    }
}
