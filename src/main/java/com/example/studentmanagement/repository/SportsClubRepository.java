package com.example.studentmanagement.repository;

import com.example.studentmanagement.entity.SportsClub;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportsClubRepository extends JpaRepository<SportsClub, Integer> {
}
