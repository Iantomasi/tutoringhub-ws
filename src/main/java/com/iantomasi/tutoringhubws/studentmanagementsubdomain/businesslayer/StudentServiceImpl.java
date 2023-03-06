package com.iantomasi.tutoringhubws.studentmanagementsubdomain.businesslayer;

import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datalayer.Lesson;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datalayer.LessonRepository;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datamapperlayer.LessonRequestMapper;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datamapperlayer.LessonResponseMapper;
import com.iantomasi.tutoringhubws.studentmanagementsubdomain.datalayer.Student;
import com.iantomasi.tutoringhubws.studentmanagementsubdomain.datalayer.StudentIdentifier;
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
    private LessonRepository lessonRepository;

    public StudentServiceImpl(StudentRepository studentRepository, StudentResponseMapper studentResponseMapper, StudentRequestMapper studentRequestMapper, LessonRepository lessonRepository) {
        this.studentRepository = studentRepository;
        this.studentResponseMapper = studentResponseMapper;
        this.studentRequestMapper = studentRequestMapper;
        this.lessonRepository = lessonRepository;
    }

    @Override
    public List<StudentResponseModel> getStudents() {
        return studentResponseMapper.entityListToResponseModelList(studentRepository.findAll());
    }

    @Override
    public StudentResponseModel getStudentByStudentId(String studentId) {
        return studentResponseMapper.entityToResponseModel(studentRepository.findStudentByStudentIdentifier_StudentId(studentId));
    }

    @Override
    public StudentResponseModel addStudent(StudentRequestModel studentRequestModel, String lessonId) {
        Lesson lesson = lessonRepository.findLessonByLessonIdentifier_LessonId(lessonId);

        if(lesson == null){
            return null;
        }

        StudentIdentifier studentIdentifier = new StudentIdentifier(studentRequestModel.getStudentId());


        Student student = studentRequestMapper.requestModelToEntity(studentRequestModel, studentIdentifier, lesson.getLessonIdentifier());
        Student saved = studentRepository.save(student);
        return studentResponseMapper.entityToResponseModel(saved);
    }

    @Override
    public StudentResponseModel updateStudent(StudentRequestModel studentRequestModel, String studentId){

        Student existingStudent = studentRepository.findStudentByStudentIdentifier_StudentId(studentId);
        if(existingStudent == null){
            return null;
        }

        Student student = studentRequestMapper.requestModelToEntity(studentRequestModel, existingStudent.getStudentIdentifier(), existingStudent.getLessonIdentifier());
        student.setId(existingStudent.getId());
        return studentResponseMapper.entityToResponseModel(studentRepository.save(student));
    }


    @Override
    public void removeStudent(String studentId) {
        Student existingStudent = studentRepository.findStudentByStudentIdentifier_StudentId(studentId);
        if(existingStudent == null){
            return;
        }
        studentRepository.delete(existingStudent);
    }
}
