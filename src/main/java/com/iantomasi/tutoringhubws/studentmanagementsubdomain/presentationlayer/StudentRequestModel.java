package com.iantomasi.tutoringhubws.studentmanagementsubdomain.presentationlayer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class StudentRequestModel {

    private String studentId;
    private String inventoryId;
    private String studentName;
    private String studentAge;
    private String studentEmail;
    private String studentSchool;
}
