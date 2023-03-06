package com.iantomasi.tutoringhubws.studentmanagementsubdomain.datamapperlayer;

import com.iantomasi.tutoringhubws.studentmanagementsubdomain.datalayer.Student;
import com.iantomasi.tutoringhubws.studentmanagementsubdomain.presentationlayer.StudentResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentResponseMapper {

    @Mapping(expression = "java(student.getStudentIdentifier().getStudentId())", target = "studentId")
    @Mapping(expression = "java(student.getLessonIdentifier().getLessonId())", target = "lessonId")
    StudentResponseModel entityToResponseModel(Student student);
    List<StudentResponseModel> entityListToResponseModelList(List<Student> students);

}

