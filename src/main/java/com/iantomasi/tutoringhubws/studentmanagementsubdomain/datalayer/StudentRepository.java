package com.iantomasi.tutoringhubws.studentmanagementsubdomain.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findStudentByStudentIdentifier_StudentId(String studentId);
}
