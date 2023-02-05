package com.example.studentmanagement.service.custom;

import com.example.studentmanagement.dto.SchoolDTO;
import com.example.studentmanagement.dto.StudentDTO;
import com.example.studentmanagement.service.SuperService;

public interface SchoolService extends SuperService {
    SchoolDTO createNewSchool(SchoolDTO schoolDTO);
    StudentDTO getSchoolDetails(Integer schoolId);
    void updateSchoolDetails(SchoolDTO schoolDTO);
    void deleteSchool(Integer studentId);

}
