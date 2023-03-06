package com.iantomasi.tutoringhubws.studentmanagementsubdomain.presentationlayer;

import com.iantomasi.tutoringhubws.studentmanagementsubdomain.businesslayer.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public List<StudentResponseModel> getStudents(){ return studentService.getStudents(); }

    @GetMapping("/{studentId}")
    public StudentResponseModel getStudentByStudentId(@PathVariable String studentId){
        return studentService.getStudentByStudentId(studentId);
    }

    @PostMapping("/{lessonId}")
    public StudentResponseModel addStudent(@RequestBody StudentRequestModel studentRequestModel, @PathVariable String lessonId){
        return studentService.addStudent(studentRequestModel, lessonId);
    }


    @PutMapping("/{studentId}")
    public StudentResponseModel updateStudent(@RequestBody StudentRequestModel studentRequestModel, @PathVariable String studentId){
        return studentService.updateStudent(studentRequestModel, studentId);
    }

    @DeleteMapping("/{studentId}")
    void removeStudent(@PathVariable String studentId){
        studentService.removeStudent(studentId);
    }

}
