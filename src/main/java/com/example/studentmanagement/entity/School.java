package com.example.studentmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor@NoArgsConstructor
public class School implements SuperEntity{
    @Id
    private int id;
    @Column(nullable = false)
    private String  name;
    @Column(nullable = false)
    private String address;
}
