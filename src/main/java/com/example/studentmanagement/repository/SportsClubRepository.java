package com.example.studentmanagement.repository;

import com.example.studentmanagement.entity.School;
import com.example.studentmanagement.entity.SportsClub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface SportsClubRepository extends JpaRepository<SportsClub, Integer> {
    @Query()
    List<School> getSchoolsBySportsClub(Integer id);
}
