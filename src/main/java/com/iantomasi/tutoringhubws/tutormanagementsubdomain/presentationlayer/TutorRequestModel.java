package com.iantomasi.tutoringhubws.tutormanagementsubdomain.presentationlayer;

import com.iantomasi.tutoringhubws.tutormanagementsubdomain.datalayer.Experience;
import com.iantomasi.tutoringhubws.tutormanagementsubdomain.datalayer.Specialty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TutorRequestModel {

    private String tutorName;
    private String tutorAge;
    private String tutorEmail;
    private Specialty specialty;
    private Experience experience;
}
