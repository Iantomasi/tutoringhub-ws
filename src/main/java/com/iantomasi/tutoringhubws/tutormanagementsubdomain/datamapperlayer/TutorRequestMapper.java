package com.iantomasi.tutoringhubws.tutormanagementsubdomain.datamapperlayer;

import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datalayer.LessonIdentifier;
import com.iantomasi.tutoringhubws.tutormanagementsubdomain.datalayer.Tutor;
import com.iantomasi.tutoringhubws.tutormanagementsubdomain.datalayer.TutorIdentifier;
import com.iantomasi.tutoringhubws.tutormanagementsubdomain.presentationlayer.TutorRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TutorRequestMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(expression = "java(tutorIdentifier)", target = "tutorIdentifier"),
            @Mapping(expression = "java(lessonIdentifier)", target = "lessonIdentifier")
    })
    Tutor requestModelToEntity(TutorRequestModel tutorRequestModel, TutorIdentifier tutorIdentifier, LessonIdentifier lessonIdentifier);
}
