package com.iantomasi.tutoringhubws.lessonmanagementsubdomain.businesslayer;

import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datalayer.LessonRepository;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datamapperlayer.LessonRequestMapper;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.datamapperlayer.LessonResponseMapper;
import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.presentationlayer.LessonResponseModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {

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
}
