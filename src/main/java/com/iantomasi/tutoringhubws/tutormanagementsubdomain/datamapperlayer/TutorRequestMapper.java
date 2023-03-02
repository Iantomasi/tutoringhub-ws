package com.iantomasi.tutoringhubws.tutormanagementsubdomain.datamapperlayer;

import com.iantomasi.tutoringhubws.tutormanagementsubdomain.datalayer.Tutor;
import com.iantomasi.tutoringhubws.tutormanagementsubdomain.presentationlayer.TutorRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TutorRequestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tutorIdentifier", ignore = true)
    Tutor requestModelToEntity(TutorRequestModel tutorRequestModel);
}
