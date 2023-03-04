package com.iantomasi.tutoringhubws.tutormanagementsubdomain.businesslayer;

import com.iantomasi.tutoringhubws.tutormanagementsubdomain.datalayer.Tutor;
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

    @Override
    public TutorResponseModel addTutor(TutorRequestModel tutorRequestModel) {
        Tutor tutor = tutorRequestMapper.requestModelToEntity(tutorRequestModel);
        return tutorResponseMapper.entityToResponseModel(tutorRepository.save(tutor));
    }

    @Override
    public TutorResponseModel updateTutor(TutorRequestModel tutorRequestModel, String tutorId) {

        Tutor existingTutor = tutorRepository.findTutorByTutorIdentifier_TutorId(tutorId);
        if(existingTutor == null){
            return null;
        }

        Tutor tutor = tutorRequestMapper.requestModelToEntity(tutorRequestModel);
        tutor.setId(existingTutor.getId());
        tutor.setTutorIdentifier(existingTutor.getTutorIdentifier());

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
