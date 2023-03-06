package com.iantomasi.tutoringhubws.tutormanagementsubdomain.datamapperlayer;

import com.iantomasi.tutoringhubws.tutormanagementsubdomain.datalayer.Tutor;
import com.iantomasi.tutoringhubws.tutormanagementsubdomain.presentationlayer.TutorResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TutorResponseMapper {

    @Mapping(expression = "java(tutor.getTutorIdentifier().getTutorId())", target = "tutorId")
    @Mapping(expression = "java(tutor.getLessonIdentifier().getLessonId())", target = "lessonId")
    TutorResponseModel entityToResponseModel(Tutor tutor);
    List<TutorResponseModel> entityListToResponseModelList(List<Tutor> tutors);
}
