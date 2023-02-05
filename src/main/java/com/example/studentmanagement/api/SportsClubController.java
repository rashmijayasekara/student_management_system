package com.example.studentmanagement.api;

import com.example.studentmanagement.dto.SportsClubDTO;
import com.example.studentmanagement.entity.School;
import com.example.studentmanagement.entity.SportsClub;
import com.example.studentmanagement.service.custom.SportsClubService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/sportsclub")
public class SportsClubController {
    private final SportsClubService sportsClubService;

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

        sportsClubService.createNewSportsClub(sportsClubDTO);
    }

    @GetMapping(value = "/find/{id}",produces = "application/json")
    public Optional<SportsClub> getSportsClubByID(@PathVariable("id") Integer sportsClubId){
       return sportsClubService.getSportsClubDetails(sportsClubId);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public void deleteSportsClub(@PathVariable("id") Integer sportsclubId){
        sportsClubService.deleteSportsClub(sportsclubId);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(value = "/update/{id}",consumes = "application/json")
    public void updateSportsClubDetails(@RequestBody SportsClubDTO sportsClubDTO, @PathVariable("id") Integer sportsClubId){
        sportsClubService.updateSportsClubDetails(sportsClubDTO);
    }

    @GetMapping("/all")
    public List<SportsClubDTO> getAllSportsClubs(){
        return sportsClubService.getAllSportsClubs();
    }




}
