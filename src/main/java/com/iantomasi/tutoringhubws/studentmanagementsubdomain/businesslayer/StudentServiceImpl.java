package com.iantomasi.tutoringhubws.studentmanagementsubdomain.businesslayer;

import com.iantomasi.tutoringhubws.studentmanagementsubdomain.datalayer.StudentRepository;
import com.iantomasi.tutoringhubws.studentmanagementsubdomain.datamapperlayer.StudentRequestMapper;
import com.iantomasi.tutoringhubws.studentmanagementsubdomain.datamapperlayer.StudentResponseMapper;
import com.iantomasi.tutoringhubws.studentmanagementsubdomain.presentationlayer.StudentRequestModel;
import com.iantomasi.tutoringhubws.studentmanagementsubdomain.presentationlayer.StudentResponseModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;
    private StudentResponseMapper studentResponseMapper;
    private StudentRequestMapper studentRequestMapper;

    public StudentServiceImpl(StudentRepository studentRepository, StudentResponseMapper studentResponseMapper, StudentRequestMapper studentRequestMapper) {
        this.studentRepository = studentRepository;
        this.studentResponseMapper = studentResponseMapper;
        this.studentRequestMapper = studentRequestMapper;
    }

    @Override
    public List<StudentResponseModel> getStudents() {
        return studentResponseMapper.entityListToResponseModelList(studentRepository.findAll());
    }

    @Override
    public StudentResponseModel getStudentByStudentId(String studentId) {
        return studentResponseMapper.entityToResponseModel(studentRepository.findStudentByStudentIdentifier_StudentId(studentId));
    }
}
