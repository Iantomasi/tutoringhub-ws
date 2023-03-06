package com.iantomasi.tutoringhubws.lessonmanagementsubdomain.businesslayer;

import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datalayer.Lesson;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.presentationlayer.LessonRequestModel;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.presentationlayer.LessonResponseModel;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.presentationlayer.LessonStudentResponseModel;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.presentationlayer.LessonTutorResponseModel;
import com.iantomasi.tutoringhubws.studentmanagementsubdomain.presentationlayer.StudentRequestModel;
import com.iantomasi.tutoringhubws.studentmanagementsubdomain.presentationlayer.StudentResponseModel;
import com.iantomasi.tutoringhubws.tutormanagementsubdomain.presentationlayer.TutorRequestModel;
import com.iantomasi.tutoringhubws.tutormanagementsubdomain.presentationlayer.TutorResponseModel;

import java.util.List;

public interface LessonService {

    //lesson CRUD
    List<LessonResponseModel> getLessons();
    LessonResponseModel getLessonByLessonId(String lessonId);
    LessonResponseModel addLesson(LessonRequestModel lessonRequestModel);
    LessonResponseModel updateLesson(LessonRequestModel lessonRequestModel, String lessonId);
    void removeLesson(String lessonId);


    //student CRUD
    LessonStudentResponseModel getLessonStudents(String lessonId);
    StudentResponseModel getStudentInLessonByStudentIdentifier_StudentId(String lessonId, String studentId);
    StudentResponseModel addStudentToLesson(StudentRequestModel studentRequestModel, String lessonId);
    StudentResponseModel updateStudentInLesson(StudentRequestModel studentRequestModel, String lessonId, String studentId);
    void removeStudentFromLesson(String lessonId, String studentId);


    //tutor CRUD
    LessonTutorResponseModel getLessonTutors(String lessonId);
    TutorResponseModel getTutorInLessonByTutorIdentifier_TutorId(String lessonId, String tutorId);
    TutorResponseModel addTutorToLesson(TutorRequestModel tutorRequestModel, String lessonId);
    TutorResponseModel updateTutorInLesson(TutorRequestModel tutorRequestModel, String lessonId, String tutorId);
    void removeTutorFromLesson(String lessonId, String tutorId);

}
