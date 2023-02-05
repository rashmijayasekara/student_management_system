package com.example.studentmanagement.repository;

import com.example.studentmanagement.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School,Integer> {

}
