package com.iantomasi.tutoringhubws.studentmanagementsubdomain.datamapperlayer;

import com.iantomasi.tutoringhubws.studentmanagementsubdomain.datalayer.Student;
import com.iantomasi.tutoringhubws.studentmanagementsubdomain.presentationlayer.StudentRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentRequestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "studentIdentifier", ignore = true)
    Student requestModelToEntity(StudentRequestModel studentRequestModel);

}
