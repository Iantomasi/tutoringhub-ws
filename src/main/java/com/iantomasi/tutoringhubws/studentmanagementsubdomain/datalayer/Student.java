package com.iantomasi.tutoringhubws.studentmanagementsubdomain.datalayer;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "students")
@Data
public class Student {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private StudentIdentifier studentIdentifier;


    private String studentName;
    private String studentAge;
    private String studentEmail;
    private String institutionName;


    Student() { this.studentIdentifier = new StudentIdentifier(); }

    public Student(String studentName, String studentAge, String studentEmail, String institutionName) {
        this.studentIdentifier = new StudentIdentifier();
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentEmail = studentEmail;
        this.institutionName = institutionName;
    }
}
