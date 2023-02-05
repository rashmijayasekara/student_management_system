package com.example.studentmanagement.service.custom.impl;

import com.example.studentmanagement.dto.SchoolDTO;
import com.example.studentmanagement.dto.StudentDTO;
import com.example.studentmanagement.entity.School;
import com.example.studentmanagement.repository.SchoolRepository;
import com.example.studentmanagement.service.custom.SchoolService;
import com.example.studentmanagement.util.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Component
public class SchoolServiceImpl implements SchoolService {
    private final SchoolRepository schoolRepository;
    private final Transformer transformer;


    public SchoolServiceImpl(SchoolRepository schoolRepository, Transformer transformer) {
        this.transformer=transformer;
        this.schoolRepository=schoolRepository;
    }

    @Override
    public SchoolDTO createNewSchool(SchoolDTO schoolDTO) {
        return transformer.toSchoolDTO(schoolRepository.save(transformer.toSchool(schoolDTO)));
    }

    @Override
    public SchoolDTO getSchoolDetails(Integer schoolId) {
        return null;
    }

    @Override
    public void updateSchoolDetails(SchoolDTO schoolDTO) {
        schoolRepository.save(transformer.toSchool(schoolDTO));

    }

    @Override
    public void deleteSchool(Integer studentId) {
        schoolRepository.deleteById(studentId);
    }

    @Override
    public List<SchoolDTO> getAllSchools() {
        return schoolRepository.findAll().stream().map(transformer::toSchoolDTO).collect(Collectors.toList());
    }
}
