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
//    @SequenceGenerator(
//            name = "student_sequence",
//            sequenceName = "student_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "student_sequence"
//    )
    private Long id;
    private String name;
    private String address;
    private int age;
//    @Lob
//    @Column(name = "profile_image")
    private byte[] profileImage;

    @ManyToOne
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
    public Student(Long id,String name, String address, int age,School schoolId) {
        this.id=id;
        this.name = name;
        this.address = address;
        this.age = age;
        this.schoolId = schoolId;
    }
   }
