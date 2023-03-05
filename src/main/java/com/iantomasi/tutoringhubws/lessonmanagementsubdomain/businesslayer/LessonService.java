package com.iantomasi.tutoringhubws.lessonmanagementsubdomain.businesslayer;

import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datalayer.Lesson;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.presentationlayer.LessonRequestModel;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.presentationlayer.LessonResponseModel;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.presentationlayer.LessonStudentResponseModel;
import com.iantomasi.tutoringhubws.studentmanagementsubdomain.presentationlayer.StudentResponseModel;

import java.util.List;

public interface LessonService {

    List<LessonResponseModel> getLessons();
    LessonResponseModel getLessonByLessonId(String lessonId);
    LessonResponseModel addLesson(LessonRequestModel lessonRequestModel);
    LessonResponseModel updateLesson(LessonRequestModel lessonRequestModel, String lessonId);
    void removeLesson(String lessonId);




    LessonStudentResponseModel getLessonStudents(String lessonId);
    //List<StudentResponseModel> getStudentsInLessonByLessonIdentifier_LessonId(String lessonId);





}

//get studentsInLesson
//getStudentInLessonByStudentId
//updateStudentInLesson
//removeStudentInLesson

//getTutorsInLesson
//getTutorInLessonByTutorId
//updateStudentFromLesson
//removeStudentFromLesson

