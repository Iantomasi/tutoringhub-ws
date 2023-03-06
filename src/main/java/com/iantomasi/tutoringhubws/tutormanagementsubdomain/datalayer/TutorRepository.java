package com.iantomasi.tutoringhubws.tutormanagementsubdomain.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TutorRepository extends JpaRepository<Tutor, Integer> {

    List<Tutor> findAllTutorsByLessonIdentifier_LessonId(String lessonId);
    Tutor findByLessonIdentifier_LessonIdAndTutorIdentifier_TutorId(String lessonId, String tutorId);
    Tutor findTutorByTutorIdentifier_TutorId(String tutorId);

}
