package com.iantomasi.tutoringhubws.tutormanagementsubdomain.businesslayer;

import com.iantomasi.tutoringhubws.tutormanagementsubdomain.datalayer.TutorRepository;
import com.iantomasi.tutoringhubws.tutormanagementsubdomain.datamapperlayer.TutorRequestMapper;
import com.iantomasi.tutoringhubws.tutormanagementsubdomain.datamapperlayer.TutorResponseMapper;
import com.iantomasi.tutoringhubws.tutormanagementsubdomain.presentationlayer.TutorResponseModel;

import java.util.List;

public class TutorServiceImpl implements TutorService{

    private TutorRepository tutorRepository;
    private TutorResponseMapper tutorResponseMapper;
    private TutorRequestMapper tutorRequestMapper;

    public TutorServiceImpl(TutorRepository tutorRepository, TutorResponseMapper tutorResponseMapper, TutorRequestMapper tutorRequestMapper) {
        this.tutorRepository = tutorRepository;
        this.tutorResponseMapper = tutorResponseMapper;
        this.tutorRequestMapper = tutorRequestMapper;
    }


    @Override
    public List<TutorResponseModel> getTutors() {
        return tutorResponseMapper.entityListToResponseModelList(tutorRepository.findAll());
    }

    @Override
    public TutorResponseModel getTutorByTutorId(String tutorId) {
        return tutorResponseMapper.entityToResponseModel(tutorRepository.findTutorByTutorIdentifier_TutorId(tutorId));
    }
}
