package com.iantomasi.tutoringhubws.lessonmanagementsubdomain.businesslayer;

import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datalayer.Lesson;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.presentationlayer.LessonRequestModel;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.presentationlayer.LessonResponseModel;

import java.util.List;

public interface LessonService {

    List<LessonResponseModel> getLessons();
    LessonResponseModel getLessonByLessonId(String lessonId);
    LessonResponseModel addLesson(LessonRequestModel lessonRequestModel);
    LessonResponseModel updateLesson(LessonRequestModel lessonRequestModel, String lessonId);
    void removeLesson(String lessonId);

}
