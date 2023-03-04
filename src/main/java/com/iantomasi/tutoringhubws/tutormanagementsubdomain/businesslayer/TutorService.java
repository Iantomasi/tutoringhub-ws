package com.iantomasi.tutoringhubws.tutormanagementsubdomain.businesslayer;

import com.iantomasi.tutoringhubws.studentmanagementsubdomain.presentationlayer.StudentResponseModel;
import com.iantomasi.tutoringhubws.tutormanagementsubdomain.presentationlayer.TutorRequestModel;
import com.iantomasi.tutoringhubws.tutormanagementsubdomain.presentationlayer.TutorResponseModel;

import java.util.List;

public interface TutorService {

    List<TutorResponseModel> getTutors();
    TutorResponseModel getTutorByTutorId(String tutorId);
    TutorResponseModel addTutor(TutorRequestModel tutorRequestModel);
    TutorResponseModel updateTutor(TutorRequestModel tutorRequestModel, String tutorId);
    void removeTutor(String tutorId);
}
