package com.example.studentmanagement.service.custom.impl;

import com.example.studentmanagement.dto.SportsClubDTO;
import com.example.studentmanagement.entity.SportsClub;
import com.example.studentmanagement.repository.SportsClubRepository;
import com.example.studentmanagement.service.custom.SportsClubService;
import com.example.studentmanagement.util.Transformer;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Component
public class SportsClubServiceImpl implements SportsClubService {
    private final SportsClubRepository sportsClubRepository;
    private final Transformer transformer;

    public SportsClubServiceImpl(SportsClubRepository sportsClubRepository, Transformer transformer) {
        this.sportsClubRepository = sportsClubRepository;
        this.transformer = transformer;
    }

    @Override
    public SportsClubDTO createNewSportsClub(SportsClubDTO sportsClubDTO) {

        return transformer.toSportsClubDTO(sportsClubRepository.save(transformer.toSportsClub(sportsClubDTO)));
    }

    @Override
    public Optional<SportsClub> getSportsClubDetails(Integer id) {
        return sportsClubRepository.findById(id);
    }

    @Override
    public void updateSportsClubDetails(SportsClubDTO sportsClubDTO) {
        sportsClubRepository.save(transformer.toSportsClub(sportsClubDTO));

    }

    @Override
    public void deleteSportsClub(Integer id) {
        sportsClubRepository.deleteById(id);

    }

    @Override
    public List<SportsClubDTO> getAllSportsClubs() {
        return sportsClubRepository.findAll().stream().map(transformer::toSportsClubDTO).collect(Collectors.toList());
    }
}
