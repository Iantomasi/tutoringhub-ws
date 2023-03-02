package com.iantomasi.tutoringhubws.tutormanagementsubdomain.presentationlayer;

import com.iantomasi.tutoringhubws.studentmanagementsubdomain.presentationlayer.StudentResponseModel;
import com.iantomasi.tutoringhubws.tutormanagementsubdomain.businesslayer.TutorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/tutors")
public class TutorController {

    private TutorService tutorService;

    public TutorController(TutorService tutorService){ this.tutorService = tutorService; }

    @GetMapping()
    public List<TutorResponseModel> getTutors(){ return tutorService.getTutors(); }

    @GetMapping("/{tutorId}")
    public TutorResponseModel getTutorByTutorId(@PathVariable String tutorId){
        return tutorService.getTutorByTutorId(tutorId);
    }




}
