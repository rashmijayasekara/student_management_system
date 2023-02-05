package com.example.studentmanagement.service.custom;

import com.example.studentmanagement.dto.SchoolDTO;
import com.example.studentmanagement.dto.StudentDTO;
import com.example.studentmanagement.service.SuperService;

import java.util.List;

public interface SchoolService extends SuperService {
    SchoolDTO createNewSchool(SchoolDTO schoolDTO);
    SchoolDTO getSchoolDetails(Integer schoolId);
    void updateSchoolDetails(SchoolDTO schoolDTO);
    void deleteSchool(Integer studentId);

    List<SchoolDTO> getAllSchools();

}
