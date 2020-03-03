package com.sscode;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/student")
    public String getStudentData(){
        return "Returning student data using proxy service ";
    }
}
