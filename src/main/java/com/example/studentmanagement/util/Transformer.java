package com.example.studentmanagement.util;

import com.example.studentmanagement.dto.SchoolDTO;
import com.example.studentmanagement.dto.SportsClubDTO;
import com.example.studentmanagement.dto.StudentDTO;
import com.example.studentmanagement.entity.School;
import com.example.studentmanagement.entity.SportsClub;
import com.example.studentmanagement.entity.Student;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Transformer {
    private final ModelMapper modelMapper;


    public Transformer(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Student toStudent(StudentDTO studentDTO){
        return modelMapper.map(studentDTO,Student.class);
    }
    public StudentDTO toStudentDTO(Student student){
        return modelMapper.map(student,StudentDTO.class);
    }
    public SportsClub toSportsClub(SportsClubDTO sportsClubDTO){
        return modelMapper.map(sportsClubDTO,SportsClub.class);
    }

    public SportsClubDTO toSportsClubDTO(SportsClub sportsClub){
        return modelMapper.map(sportsClub,SportsClubDTO.class);
    }
    public School toSchool(SchoolDTO schoolDTO){
        return modelMapper.map(schoolDTO,School.class);
    }
    public SchoolDTO toSchoolDTO(School school){
        return modelMapper.map(school,SchoolDTO.class);
    }
}
