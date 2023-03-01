package com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datamapperlayer;


import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datalayer.Lesson;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.presentationlayer.LessonResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LessonResponseMapper {

   @Mapping(expression = "java(lesson.getLessonIdentifier().getLessonId())", target = "lessonId")
   @Mapping(expression = "java(lesson.getAddress().getStreetAddress())", target = "streetAddress")
   @Mapping(expression = "java(lesson.getAddress().getCity())", target = "city")
   @Mapping(expression = "java(lesson.getAddress().getProvince())", target = "province")
   @Mapping(expression = "java(lesson.getAddress().getCountry())", target = "country")
   @Mapping(expression = "java(lesson.getAddress().getPostalCode())", target = "postalCode")
   LessonResponseModel entityToResponseModel(Lesson lesson);

   List<LessonResponseModel> entityListToResponseModelList(List<Lesson> lessons);




}

