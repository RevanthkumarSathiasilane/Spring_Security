package com.example.SpringSecurity.controller;

import com.example.SpringSecurity.Model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {
    List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1,"Revanth","Java"),
                    new Student(2,"Akash","Python"),
                    new Student(3,"Prejan","AI"),
                    new Student(4,"Ranjith","ML")
            )
    );
    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }
    @ GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");//attribute in logout => View page source input.
    }
    @PostMapping("/students")
    public void addStudent(@RequestBody Student student){
        students.add(student);
    }
}
