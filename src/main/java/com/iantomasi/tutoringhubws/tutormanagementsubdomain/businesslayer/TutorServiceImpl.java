package com.iantomasi.tutoringhubws.tutormanagementsubdomain.businesslayer;

import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datalayer.Lesson;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datalayer.LessonRepository;
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
public class TutorServiceImpl implements TutorService{

    private TutorRepository tutorRepository;
    private TutorResponseMapper tutorResponseMapper;
    private TutorRequestMapper tutorRequestMapper;
    private LessonRepository lessonRepository;

    public TutorServiceImpl(TutorRepository tutorRepository, TutorResponseMapper tutorResponseMapper, TutorRequestMapper tutorRequestMapper, LessonRepository lessonRepository) {
        this.tutorRepository = tutorRepository;
        this.tutorResponseMapper = tutorResponseMapper;
        this.tutorRequestMapper = tutorRequestMapper;
        this.lessonRepository = lessonRepository;
    }

    @Override
    public List<TutorResponseModel> getTutors() {
        return tutorResponseMapper.entityListToResponseModelList(tutorRepository.findAll());
    }

    @Override
    public TutorResponseModel getTutorByTutorId(String tutorId) {
        return tutorResponseMapper.entityToResponseModel(tutorRepository.findTutorByTutorIdentifier_TutorId(tutorId));
    }

    @Override
    public TutorResponseModel addTutor(TutorRequestModel tutorRequestModel, String lessonId) {

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
    public TutorResponseModel updateTutor(TutorRequestModel tutorRequestModel, String tutorId) {

        Tutor existingTutor = tutorRepository.findTutorByTutorIdentifier_TutorId(tutorId);
        if(existingTutor == null){
            return null;
        }

        Tutor tutor = tutorRequestMapper.requestModelToEntity(tutorRequestModel, existingTutor.getTutorIdentifier(), existingTutor.getLessonIdentifier());
        tutor.setId(existingTutor.getId());
        return tutorResponseMapper.entityToResponseModel(tutorRepository.save(tutor));
    }

    @Override
    public void removeTutor(String tutorId) {
        Tutor existingTutor = tutorRepository.findTutorByTutorIdentifier_TutorId(tutorId);
        if(existingTutor == null){
            return;
        }
        tutorRepository.delete(existingTutor);
    }
}
