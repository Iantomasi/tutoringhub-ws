package com.iantomasi.tutoringhubws.studentmanagementsubdomain.businesslayer;

import com.iantomasi.tutoringhubws.studentmanagementsubdomain.presentationlayer.StudentRequestModel;
import com.iantomasi.tutoringhubws.studentmanagementsubdomain.presentationlayer.StudentResponseModel;

import java.util.List;

public interface StudentService {

    List<StudentResponseModel> getStudents();
    StudentResponseModel getStudentByStudentId(String studentId);
    //StudentResponseModel updateStudent(StudentRequestModel studentRequestModel, String studentId);

    StudentResponseModel addStudent(StudentRequestModel studentRequestModel, String lessonId);
    void removeStudent(String studentId);

}
