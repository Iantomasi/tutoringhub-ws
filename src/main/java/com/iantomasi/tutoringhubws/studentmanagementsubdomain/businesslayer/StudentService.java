package com.iantomasi.tutoringhubws.studentmanagementsubdomain.businesslayer;

import com.iantomasi.tutoringhubws.studentmanagementsubdomain.presentationlayer.StudentResponseModel;

import java.util.List;

public interface StudentService {

    List<StudentResponseModel> getStudents();
    StudentResponseModel getStudentByStudentId(String studentId);
}
