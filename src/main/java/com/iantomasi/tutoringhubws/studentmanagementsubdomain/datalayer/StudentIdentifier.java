package com.iantomasi.tutoringhubws.studentmanagementsubdomain.datalayer;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class StudentIdentifier {

    private String studentId;

    StudentIdentifier(){}

    public StudentIdentifier(String studentId){ this.studentId = studentId; }

    public String getStudentId(){ return studentId; }

}
