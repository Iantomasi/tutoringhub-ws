package com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datamapperlayer;

import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datalayer.Lesson;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.presentationlayer.LessonTutorResponseModel;
import com.iantomasi.tutoringhubws.tutormanagementsubdomain.presentationlayer.TutorResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LessonTutorResponseMapper {

    @Mapping(expression = "java(lesson.getLessonIdentifier().getLessonId())", target = "lessonId")
    @Mapping(expression = "java(tutors)", target = "lessonTutors")
    LessonTutorResponseModel entitiesToResponseModel(Lesson lesson, List<TutorResponseModel> tutors);

}
