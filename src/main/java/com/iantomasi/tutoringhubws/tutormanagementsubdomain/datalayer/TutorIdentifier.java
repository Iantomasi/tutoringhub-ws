package com.iantomasi.tutoringhubws.tutormanagementsubdomain.datalayer;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class TutorIdentifier {

    private String tutorId;

    TutorIdentifier(){}

    public TutorIdentifier(String tutorId){ this.tutorId = tutorId; }

    public String getTutorId(){ return tutorId; }

}
