package com.iantomasi.tutoringhubws.lessonmanagementsubdomain.presentationlayer;

import com.iantomasi.tutoringhubws.lessonmanagementsubdomain.businesslayer.LessonService;
import com.iantomasi.tutoringhubws.studentmanagementsubdomain.presentationlayer.StudentResponseModel;
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



    @GetMapping("/{lessonId}/students")
    LessonStudentResponseModel getLessonStudents(@PathVariable String lessonId){
        return lessonService.getLessonStudents(lessonId);
    }


    @GetMapping("/{lessonId}/students/{studentId}")
    StudentResponseModel getStudentInLesson(@PathVariable String lessonId, @PathVariable String studentId){
        return lessonService.getStudentInLessonByStudentIdentifier_StudentId(lessonId, studentId);
    }





}
