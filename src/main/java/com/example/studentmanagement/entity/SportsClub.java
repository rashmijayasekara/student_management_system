package com.example.studentmanagement.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor @AllArgsConstructor @Data
public class SportsClub implements SuperEntity{
    @Id
    private int id;
    @Column(nullable = false)
    private String name;

    @Setter(AccessLevel.NONE)
    @ManyToMany
    @JoinTable(
            name = "student_sportsclub",
            joinColumns = @JoinColumn(name = "sportsclub_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> studentSet=new HashSet<>();
}
