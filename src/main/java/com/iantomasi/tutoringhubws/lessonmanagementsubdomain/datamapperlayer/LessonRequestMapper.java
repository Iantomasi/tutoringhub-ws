package com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datamapperlayer;

import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datalayer.Lesson;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.presentationlayer.LessonRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LessonRequestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "lessonIdentifier", ignore = true)
    Lesson requestModelToEntity(LessonRequestModel lessonRequestModel);

}
