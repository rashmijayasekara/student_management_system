package com.example.studentmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor@NoArgsConstructor
public class School implements SuperEntity{
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String  name;
    @Column(nullable = false)
    private String address;

    @Autowired
    public School(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
