package com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datamapperlayer;

import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datalayer.Lesson;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.presentationlayer.LessonStudentResponseModel;
import com.iantomasi.tutoringhubws.studentmanagementsubdomain.presentationlayer.StudentResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LessonStudentResponseMapper {

    @Mapping(expression = "java(lesson.getLessonIdentifier().getLessonId())", target = "lessonId")
    @Mapping(expression = "java(students)", target = "lessonStudents")
    LessonStudentResponseModel entitiesToResponseModel(Lesson lesson, List<StudentResponseModel> students);



}
