package com.iantomasi.tutoringhubws.lessonmanagementsubdomain.presentationlayer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LessonResponseModel {

    private String lessonId;
    private String lessonSubject;
    private String lessonDate;
    private String paymentStatus;
    private String streetAddress;
    private String city;
    private String province;
    private String country;
    private String postalCode;



}
