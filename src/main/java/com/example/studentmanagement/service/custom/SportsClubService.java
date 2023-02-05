package com.example.studentmanagement.service.custom;

import com.example.studentmanagement.dto.SportsClubDTO;
import com.example.studentmanagement.dto.StudentDTO;
import com.example.studentmanagement.service.SuperService;

public interface SportsClubService extends SuperService {
    SportsClubDTO createNewSportsClub(SportsClubDTO sportsClubDTO);
    SportsClubDTO getSportsClubDetails(Integer id);
    void updateSportsClubDetails(SportsClubDTO sportsClubDTO);
    void deleteSportsClub(Integer id);
}
