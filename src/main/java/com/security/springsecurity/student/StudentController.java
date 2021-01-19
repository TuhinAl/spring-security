package com.security.springsecurity.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author Alauddin Tuhin
 * @created_on 1/18/21 at 1:23 PM
 * @project - springsecurity
 **/
@RestController
@RequestMapping("/student/by")
public class StudentController {
    List<Student> STUDENT= Arrays.asList(
            new Student(1, "Abdur Razzak"),
            new Student(2, "Tamim Iqbal"),
            new Student(3, "Musfiqur Rahman")

    );

     @GetMapping(path="{id}")
    public Student getStudentById(@PathVariable("id") Integer studentId){
         return STUDENT.stream()
                 .filter( student -> studentId.equals(student.getId()))
                 .findFirst()
                 .orElseThrow(()->new IllegalStateException("Student with this" +studentId +"doesn't exist"));

    }

}
