package com.example.studentmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data @NoArgsConstructor @AllArgsConstructor
public class SchoolDTO implements Serializable {
    private int id;
    private String name;
    private String address;


}
