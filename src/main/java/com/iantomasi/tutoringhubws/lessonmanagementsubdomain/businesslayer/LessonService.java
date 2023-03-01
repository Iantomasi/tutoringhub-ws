package com.iantomasi.tutoringhubws.lessonmanagementsubdomain.businesslayer;

import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.presentationlayer.LessonResponseModel;

import java.util.List;

public interface LessonService {

    List<LessonResponseModel> getLessons();
    LessonResponseModel getLessonByLessonId(String lessonId);



}
