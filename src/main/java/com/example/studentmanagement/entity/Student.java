package com.example.studentmanagement.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
public class Student implements SuperEntity{
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
    private int age;
    @Lob
    @Column(name = "profile_image")
    private byte[] profileImage;

    @ManyToOne(targetEntity = School.class)
   @JoinColumn(name = "school_id",referencedColumnName = "id",nullable = false)
        private School schoolId;



    @ManyToMany(mappedBy = "studentSet")
    private Set<SportsClub> sportsClubSet=new HashSet<>();



    public Student(String name, String address, int age, byte[] profileImage,School schoolId) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.profileImage = profileImage;
        this.schoolId = schoolId;
    }

    @Autowired
    public Student(String name, String address, int age,School schoolId) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.schoolId = schoolId;
    }
   }
