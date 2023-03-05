package com.iantomasi.tutoringhubws.lessonmanagementsubdomain.businesslayer;

import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datalayer.Address;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datalayer.Lesson;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datalayer.LessonRepository;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datamapperlayer.LessonRequestMapper;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datamapperlayer.LessonResponseMapper;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datamapperlayer.LessonStudentResponseMapper;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.presentationlayer.LessonRequestModel;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.presentationlayer.LessonResponseModel;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.presentationlayer.LessonStudentResponseModel;
import com.iantomasi.tutoringhubws.studentmanagementsubdomain.datalayer.Student;
import com.iantomasi.tutoringhubws.studentmanagementsubdomain.datalayer.StudentRepository;
import com.iantomasi.tutoringhubws.studentmanagementsubdomain.datamapperlayer.StudentRequestMapper;
import com.iantomasi.tutoringhubws.studentmanagementsubdomain.datamapperlayer.StudentResponseMapper;
import com.iantomasi.tutoringhubws.studentmanagementsubdomain.presentationlayer.StudentResponseModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService{


    private LessonRepository lessonRepository;
    private LessonResponseMapper lessonResponseMapper;
    private LessonRequestMapper lessonRequestMapper;

    private StudentRepository studentRepository;
    private StudentResponseMapper studentResponseMapper;
    private StudentRequestMapper studentRequestMapper;

    private LessonStudentResponseMapper lessonStudentResponseMapper;

    public LessonServiceImpl(LessonRepository lessonRepository, LessonResponseMapper lessonResponseMapper, LessonRequestMapper lessonRequestMapper, StudentRepository studentRepository, StudentResponseMapper studentResponseMapper, StudentRequestMapper studentRequestMapper, LessonStudentResponseMapper lessonStudentResponseMapper) {
        this.lessonRepository = lessonRepository;
        this.lessonResponseMapper = lessonResponseMapper;
        this.lessonRequestMapper = lessonRequestMapper;
        this.studentRepository = studentRepository;
        this.studentResponseMapper = studentResponseMapper;
        this.studentRequestMapper = studentRequestMapper;
        this.lessonStudentResponseMapper = lessonStudentResponseMapper;
    }

    @Override
    public List<LessonResponseModel> getLessons() {
        return lessonResponseMapper.entityListToResponseModelList(lessonRepository.findAll());
    }

    @Override
    public LessonResponseModel getLessonByLessonId(String lessonId) {

        return lessonResponseMapper.entityToResponseModel(lessonRepository.findLessonByLessonIdentifier_LessonId(lessonId));
    }

    @Override
    public LessonResponseModel addLesson(LessonRequestModel lessonRequestModel) {

        Address address = new Address(lessonRequestModel.getStreetAddress(), lessonRequestModel.getCity(),
                lessonRequestModel.getPostalCode());
        Lesson lesson = lessonRequestMapper.requestModelToEntity(lessonRequestModel);
        lesson.setAddress(address);
        return lessonResponseMapper.entityToResponseModel(lessonRepository.save(lesson));
    }

    @Override
    public LessonResponseModel updateLesson(LessonRequestModel lessonRequestModel, String lessonId) {


        Lesson existingLesson = lessonRepository.findLessonByLessonIdentifier_LessonId(lessonId);

        if(existingLesson == null){
            return null;
        }

        Address address = new Address(lessonRequestModel.getStreetAddress(), lessonRequestModel.getCity(),
                lessonRequestModel.getPostalCode());

        Lesson lesson = lessonRequestMapper.requestModelToEntity(lessonRequestModel);
        lesson.setAddress(address);
        lesson.setId(existingLesson.getId());
        lesson.setLessonIdentifier(existingLesson.getLessonIdentifier());

        return lessonResponseMapper.entityToResponseModel(lessonRepository.save(lesson));
    }

    @Override
    public void removeLesson(String lessonId) {

        Lesson existingLesson = lessonRepository.findLessonByLessonIdentifier_LessonId(lessonId);

        if(existingLesson == null){
            return;
        }
        lessonRepository.delete(existingLesson);
    }


    //students

    @Override
    public LessonStudentResponseModel getLessonStudents(String lessonId) {

        //get lesson

        Lesson lesson = lessonRepository.findLessonByLessonIdentifier_LessonId(lessonId);

        if(lesson == null){
            return null;
        }

        List<Student> students = studentRepository.findAllStudentsByLessonIdentifier_LessonId(lessonId);
        List<StudentResponseModel> studentResponseModels = studentResponseMapper.entityListToResponseModelList(students);

        return lessonStudentResponseMapper.entitiesToResponseModel(lesson, studentResponseModels);
    }

    @Override
    public StudentResponseModel getStudentInLessonByStudentIdentifier_StudentId(String lessonId, String studentId) {

    if(!lessonRepository.existsLessonByLessonIdentifier_LessonId(lessonId)){
        return null;
    }

    Student foundStudent = studentRepository.findByLessonIdentifier_LessonIdAndStudentIdentifier_StudentId(lessonId, studentId);

    if(foundStudent == null){
        return null;
    }
    return studentResponseMapper.entityToResponseModel(foundStudent);
    }


}
