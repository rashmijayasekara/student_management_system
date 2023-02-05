package com.example.studentmanagement.service.custom;

import com.example.studentmanagement.dto.SportsClubDTO;
import com.example.studentmanagement.entity.SportsClub;
import com.example.studentmanagement.service.SuperService;

import java.util.List;
import java.util.Optional;

public interface SportsClubService extends SuperService {
    SportsClubDTO createNewSportsClub(SportsClubDTO sportsClubDTO);
    Optional<SportsClub> getSportsClubDetails(Integer id);
    void updateSportsClubDetails(SportsClubDTO sportsClubDTO);
    void deleteSportsClub(Integer id);
    List<SportsClubDTO> getAllSportsClubs();
}
