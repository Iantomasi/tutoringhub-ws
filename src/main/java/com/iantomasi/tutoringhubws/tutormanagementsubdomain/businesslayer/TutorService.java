package com.iantomasi.tutoringhubws.tutormanagementsubdomain.businesslayer;

import com.iantomasi.tutoringhubws.tutormanagementsubdomain.presentationlayer.TutorResponseModel;

import java.util.List;

public interface TutorService {

    List<TutorResponseModel> getTutors();
    TutorResponseModel getTutorByTutorId(String tutorId);

}
