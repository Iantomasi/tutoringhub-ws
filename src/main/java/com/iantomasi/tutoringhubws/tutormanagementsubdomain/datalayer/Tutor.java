package com.iantomasi.tutoringhubws.tutormanagementsubdomain.datalayer;

import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datalayer.LessonIdentifier;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tutors")
@Data
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private TutorIdentifier tutorIdentifier;

    @Embedded
    private LessonIdentifier lessonIdentifier;

    private String tutorName;
    private String tutorAge;
    private String tutorEmail;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Enumerated(EnumType.STRING)
    private Experience experience;


    Tutor(){ this.tutorIdentifier = new TutorIdentifier(); }

    public Tutor(String tutorName, String tutorAge, String tutorEmail) {
        this.tutorIdentifier = new TutorIdentifier();
        this.tutorName = tutorName;
        this.tutorAge = tutorAge;
        this.tutorEmail = tutorEmail;
    }
}
