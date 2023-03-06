package com.iantomasi.tutoringhubws.lessonmanagementsubdomain.businesslayer;

import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datalayer.Address;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datalayer.Lesson;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datalayer.LessonRepository;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datamapperlayer.LessonRequestMapper;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datamapperlayer.LessonResponseMapper;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datamapperlayer.LessonStudentResponseMapper;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datamapperlayer.LessonTutorResponseMapper;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.presentationlayer.LessonRequestModel;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.presentationlayer.LessonResponseModel;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.presentationlayer.LessonStudentResponseModel;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.presentationlayer.LessonTutorResponseModel;
import com.iantomasi.tutoringhubws.studentmanagementsubdomain.datalayer.Student;
import com.iantomasi.tutoringhubws.studentmanagementsubdomain.datalayer.StudentIdentifier;
import com.iantomasi.tutoringhubws.studentmanagementsubdomain.datalayer.StudentRepository;
import com.iantomasi.tutoringhubws.studentmanagementsubdomain.datamapperlayer.StudentRequestMapper;
import com.iantomasi.tutoringhubws.studentmanagementsubdomain.datamapperlayer.StudentResponseMapper;
import com.iantomasi.tutoringhubws.studentmanagementsubdomain.presentationlayer.StudentRequestModel;
import com.iantomasi.tutoringhubws.studentmanagementsubdomain.presentationlayer.StudentResponseModel;
import com.iantomasi.tutoringhubws.tutormanagementsubdomain.datalayer.Tutor;
import com.iantomasi.tutoringhubws.tutormanagementsubdomain.datalayer.TutorIdentifier;
import com.iantomasi.tutoringhubws.tutormanagementsubdomain.datalayer.TutorRepository;
import com.iantomasi.tutoringhubws.tutormanagementsubdomain.datamapperlayer.TutorRequestMapper;
import com.iantomasi.tutoringhubws.tutormanagementsubdomain.datamapperlayer.TutorResponseMapper;
import com.iantomasi.tutoringhubws.tutormanagementsubdomain.presentationlayer.TutorRequestModel;
import com.iantomasi.tutoringhubws.tutormanagementsubdomain.presentationlayer.TutorResponseModel;
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

    private TutorRepository tutorRepository;
    private TutorResponseMapper tutorResponseMapper;
    private TutorRequestMapper tutorRequestMapper;

    private LessonStudentResponseMapper lessonStudentResponseMapper;
    private LessonTutorResponseMapper lessonTutorResponseMapper;

    public LessonServiceImpl(LessonRepository lessonRepository, LessonResponseMapper lessonResponseMapper, LessonRequestMapper lessonRequestMapper, StudentRepository studentRepository, StudentResponseMapper studentResponseMapper, StudentRequestMapper studentRequestMapper, TutorRepository tutorRepository, TutorResponseMapper tutorResponseMapper, TutorRequestMapper tutorRequestMapper, LessonStudentResponseMapper lessonStudentResponseMapper, LessonTutorResponseMapper lessonTutorResponseMapper) {
        this.lessonRepository = lessonRepository;
        this.lessonResponseMapper = lessonResponseMapper;
        this.lessonRequestMapper = lessonRequestMapper;
        this.studentRepository = studentRepository;
        this.studentResponseMapper = studentResponseMapper;
        this.studentRequestMapper = studentRequestMapper;
        this.tutorRepository = tutorRepository;
        this.tutorResponseMapper = tutorResponseMapper;
        this.tutorRequestMapper = tutorRequestMapper;
        this.lessonStudentResponseMapper = lessonStudentResponseMapper;
        this.lessonTutorResponseMapper = lessonTutorResponseMapper;
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

    @Override
    public StudentResponseModel addStudentToLesson(StudentRequestModel studentRequestModel, String lessonId) {

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
    public StudentResponseModel updateStudentInLesson(StudentRequestModel studentRequestModel, String lessonId, String studentId) {

        if(!lessonRepository.existsLessonByLessonIdentifier_LessonId(lessonId)){
            return null;
        }
        Student student = studentRepository.findStudentByStudentIdentifier_StudentId(studentId);

        if(student == null){
            return null;
        }

        Student updatedStudent = studentRequestMapper.requestModelToEntity(studentRequestModel, student.getStudentIdentifier(), student.getLessonIdentifier());
        updatedStudent.setId(student.getId());
        return studentResponseMapper.entityToResponseModel(studentRepository.save(updatedStudent));
    }


    @Override
    public void removeStudentFromLesson(String lessonId, String studentId) {

        if(!lessonRepository.existsLessonByLessonIdentifier_LessonId(lessonId)){
            return;
        }

        Student student = studentRepository.findStudentByStudentIdentifier_StudentId(studentId);

        if(student == null){
            return;
        }
        studentRepository.delete(student);
    }


    //tutors

    @Override
    public LessonTutorResponseModel getLessonTutors(String lessonId) {

        Lesson lesson = lessonRepository.findLessonByLessonIdentifier_LessonId(lessonId);
        if(lesson == null){
            return null;
        }

        List<Tutor> tutors = tutorRepository.findAllTutorsByLessonIdentifier_LessonId(lessonId);
        List<TutorResponseModel> tutorResponseModels = tutorResponseMapper.entityListToResponseModelList(tutors);
        return lessonTutorResponseMapper.entitiesToResponseModel(lesson, tutorResponseModels);
    }

    @Override
    public TutorResponseModel getTutorInLessonByTutorIdentifier_TutorId(String lessonId, String tutorId) {

        if(!lessonRepository.existsLessonByLessonIdentifier_LessonId(lessonId)){
            return null;
        }

        Tutor foundTutor = tutorRepository.findByLessonIdentifier_LessonIdAndTutorIdentifier_TutorId(lessonId, tutorId);

        if(foundTutor == null){
            return null;
        }
        return tutorResponseMapper.entityToResponseModel(foundTutor);
    }

    @Override
    public TutorResponseModel addTutorToLesson(TutorRequestModel tutorRequestModel, String lessonId) {


        Lesson lesson = lessonRepository.findLessonByLessonIdentifier_LessonId(lessonId);
        if(lesson == null){
            return null;
        }

        TutorIdentifier tutorIdentifier = new TutorIdentifier(tutorRequestModel.getTutorId());
        Tutor tutor = tutorRequestMapper.requestModelToEntity(tutorRequestModel, tutorIdentifier, lesson.getLessonIdentifier());
        Tutor saved = tutorRepository.save(tutor);
        return tutorResponseMapper.entityToResponseModel(saved);
    }

    @Override
    public TutorResponseModel updateTutorInLesson(TutorRequestModel tutorRequestModel, String lessonId, String tutorId) {

        if(!lessonRepository.existsLessonByLessonIdentifier_LessonId(lessonId)){
            return null;
        }

        Tutor tutor = tutorRepository.findTutorByTutorIdentifier_TutorId(tutorId);

        if(tutor == null){
            return null;
        }

        Tutor updatedTutor = tutorRequestMapper.requestModelToEntity(tutorRequestModel, tutor.getTutorIdentifier(), tutor.getLessonIdentifier());
        updatedTutor.setId(tutor.getId());
        return tutorResponseMapper.entityToResponseModel(tutorRepository.save(updatedTutor));
    }

    @Override
    public void removeTutorFromLesson(String lessonId, String tutorId) {

        if(!lessonRepository.existsLessonByLessonIdentifier_LessonId(lessonId)){
            return;
        }

        Tutor tutor = tutorRepository.findTutorByTutorIdentifier_TutorId(tutorId);

        if(tutor == null){
        return;
        }
        tutorRepository.delete(tutor);

    }


}
