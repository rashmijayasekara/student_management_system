package com.example.studentmanagement.repository;

import com.example.studentmanagement.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchoolRepository extends JpaRepository<School,Integer> {

}
