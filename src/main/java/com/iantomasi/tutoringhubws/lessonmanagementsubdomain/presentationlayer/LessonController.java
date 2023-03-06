package com.iantomasi.tutoringhubws.lessonmanagementsubdomain.presentationlayer;

import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.businesslayer.LessonService;
import com.iantomasi.tutoringhubws.studentmanagementsubdomain.presentationlayer.StudentRequestModel;
import com.iantomasi.tutoringhubws.studentmanagementsubdomain.presentationlayer.StudentResponseModel;
import com.iantomasi.tutoringhubws.tutormanagementsubdomain.presentationlayer.TutorRequestModel;
import com.iantomasi.tutoringhubws.tutormanagementsubdomain.presentationlayer.TutorResponseModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/lessons")
public class LessonController {

    private LessonService lessonService;

    public LessonController(LessonService lessonService){ this.lessonService = lessonService; }

    @GetMapping()
    public List<LessonResponseModel> getLessons(){
        return lessonService.getLessons();
    }

    @GetMapping("/{lessonId}")
    public LessonResponseModel getLessonByLessonId(@PathVariable String lessonId){
        return lessonService.getLessonByLessonId(lessonId);
    }

    @PostMapping()
    public LessonResponseModel addLesson(@RequestBody LessonRequestModel lessonRequestModel){
        return lessonService.addLesson(lessonRequestModel);
    }

    @PutMapping("/{lessonId}")
    public LessonResponseModel updateLesson(@RequestBody LessonRequestModel lessonRequestModel, @PathVariable String lessonId){
        return lessonService.updateLesson(lessonRequestModel, lessonId);
    }

    @DeleteMapping("/{lessonId}")
    public void removeLesson(@PathVariable String lessonId){
        lessonService.removeLesson(lessonId);
    }



    //students
    @GetMapping("/{lessonId}/students")
    LessonStudentResponseModel getLessonStudents(@PathVariable String lessonId){
        return lessonService.getLessonStudents(lessonId);
    }


    @GetMapping("/{lessonId}/students/{studentId}")
    StudentResponseModel getStudentInLesson(@PathVariable String lessonId, @PathVariable String studentId){
        return lessonService.getStudentInLessonByStudentIdentifier_StudentId(lessonId, studentId);
    }


    @PostMapping("/{lessonId}/students")
    StudentResponseModel addStudentToLesson(@RequestBody StudentRequestModel studentRequestModel, @PathVariable String lessonId){
        return lessonService.addStudentToLesson(studentRequestModel, lessonId);
    }


    @PutMapping("/{lessonId}/students/{studentId}")
    public StudentResponseModel updateStudentInLesson(@RequestBody StudentRequestModel studentRequestModel, @PathVariable String lessonId, @PathVariable String studentId){
        return lessonService.updateStudentInLesson(studentRequestModel, lessonId, studentId);
    }

    @DeleteMapping("{lessonId}/students/{studentId}")
    public void removeStudentFromLesson(@PathVariable String lessonId, @PathVariable String studentId){
        lessonService.removeStudentFromLesson(lessonId, studentId);
    }

    //tutors

     @GetMapping("/{lessonId}/tutors")
    LessonTutorResponseModel getLessonTutors(@PathVariable String lessonId){
        return lessonService.getLessonTutors(lessonId);
    }



    @GetMapping("/{lessonId}/tutors/{tutorId}")
    TutorResponseModel getTutorInLesson(@PathVariable String lessonId, @PathVariable String tutorId){
        return lessonService.getTutorInLessonByTutorIdentifier_TutorId(lessonId, tutorId);
    }


    @PostMapping("/{lessonId}/tutors")
    TutorResponseModel addTutorToLesson(@RequestBody TutorRequestModel tutorRequestModel, @PathVariable String lessonId){
        return lessonService.addTutorToLesson(tutorRequestModel, lessonId);
    }


    @PutMapping("/{lessonId}/tutors/{tutorId}")
    public TutorResponseModel updateTutorInLesson(@RequestBody TutorRequestModel tutorRequestModel, @PathVariable String lessonId, @PathVariable String tutorId){
        return lessonService.updateTutorInLesson(tutorRequestModel, lessonId, tutorId);
    }

    @DeleteMapping("{lessonId}/tutors/{tutorId}")
    public void removeTutorFromLesson(@PathVariable String lessonId, @PathVariable String tutorId){
        lessonService.removeTutorFromLesson(lessonId, tutorId);
    }




}
