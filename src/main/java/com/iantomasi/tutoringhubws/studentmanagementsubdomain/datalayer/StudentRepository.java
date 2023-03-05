package com.iantomasi.tutoringhubws.studentmanagementsubdomain.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    //Student findStudentByStudentIdentifier_StudentId(String studentId);

    List<Student> findAllStudentsByLessonIdentifier_LessonId(String lessonId);
    Student findByLessonIdentifier_LessonIdAndStudentIdentifier_StudentId(String lessonId, String studentId);
    Student findStudentByStudentIdentifier_StudentId(String studentId);
}
