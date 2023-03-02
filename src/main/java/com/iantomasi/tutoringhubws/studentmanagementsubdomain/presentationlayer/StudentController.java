package com.iantomasi.tutoringhubws.studentmanagementsubdomain.presentationlayer;

import com.iantomasi.tutoringhubws.studentmanagementsubdomain.businesslayer.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
