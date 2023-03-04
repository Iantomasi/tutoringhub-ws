package com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datalayer;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "lessons")
@Data
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Embedded
    private LessonIdentifier lessonIdentifier;

    private String lessonSubject;
    private String lessonDate;
    private String lessonDuration;



    @Embedded
    private Address address;

    Lesson(){ this.lessonIdentifier = new LessonIdentifier(); }

    public Lesson(String lessonSubject, String lessonDate, Address address) {
        this.lessonIdentifier = new LessonIdentifier();
        this.lessonSubject = lessonSubject;
        this.lessonDate = lessonDate;
        this.address = address;
    }
}
