package com.example.course.enrollment.system.controller;


import com.example.course.enrollment.system.model.Course;
import com.example.course.enrollment.system.model.CourseRegistration;
import com.example.course.enrollment.system.service.CourseService;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@CrossOrigin(origins = "http://localhost:5500")
public class CourseController {
    @Autowired
     CourseService courseService;


    @GetMapping("/available")
    public List<Course> getAllDetails()
    {
        return courseService.getAllDetails();
    }

//    @GetMapping("enrolled")
//    public List<CourseRegistration> getAllCourse(){
//        return courseService.getAllCourse();
//    }

    @PostMapping("/register")
    public String enrollCourse(@RequestParam("name") String name,
                               @RequestParam("email") String email,
                               @RequestParam("courseName")String courseName)
    {
        courseService.enrollCourse(name,email,courseName);
        return "Course registered successsfully";
    }
    @GetMapping("/home")
    public String home()
    {
        return "Home pages";
    }
}
