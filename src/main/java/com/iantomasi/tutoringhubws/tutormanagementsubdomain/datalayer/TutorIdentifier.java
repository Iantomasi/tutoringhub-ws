package com.iantomasi.tutoringhubws.tutormanagementsubdomain.datalayer;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class TutorIdentifier {

    private String tutorId;
    TutorIdentifier(){ this.tutorId = UUID.randomUUID().toString(); }

    public String getTutorId(){ return tutorId; }

}
