package com.iantomasi.tutoringhubws.studentmanagementsubdomain.datamapperlayer;

import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datalayer.LessonIdentifier;
import com.iantomasi.tutoringhubws.studentmanagementsubdomain.datalayer.Student;
import com.iantomasi.tutoringhubws.studentmanagementsubdomain.datalayer.StudentIdentifier;
import com.iantomasi.tutoringhubws.studentmanagementsubdomain.presentationlayer.StudentRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface StudentRequestMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(expression = "java(studentIdentifier)", target = "studentIdentifier"),
            @Mapping(expression = "java(lessonIdentifier)", target = "lessonIdentifier")
    })
    Student requestModelToEntity(StudentRequestModel studentRequestModel, StudentIdentifier studentIdentifier, LessonIdentifier lessonIdentifier);

}