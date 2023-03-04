package com.iantomasi.tutoringhubws.lessonmanagementsubdomain.businesslayer;

import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datalayer.Address;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datalayer.Lesson;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datalayer.LessonRepository;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datamapperlayer.LessonRequestMapper;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datamapperlayer.LessonResponseMapper;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.presentationlayer.LessonRequestModel;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.presentationlayer.LessonResponseModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService{


    private LessonRepository lessonRepository;
    private LessonResponseMapper lessonResponseMapper;
    private LessonRequestMapper lessonRequestMapper;

    public LessonServiceImpl(LessonRepository lessonRepository, LessonResponseMapper lessonResponseMapper, LessonRequestMapper lessonRequestMapper) {
        this.lessonRepository = lessonRepository;
        this.lessonResponseMapper = lessonResponseMapper;
        this.lessonRequestMapper = lessonRequestMapper;
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
}
