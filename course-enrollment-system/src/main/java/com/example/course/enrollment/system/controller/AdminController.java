package com.example.course.enrollment.system.controller;


import com.example.course.enrollment.system.model.CourseRegistration;
import com.example.course.enrollment.system.model.Users;
import com.example.course.enrollment.system.service.CourseService;
import com.example.course.enrollment.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    CourseService courseService;
    @Autowired
    UserService userService;
    @PostMapping("/add-user")
    public void addUser(@RequestBody Users users)
    {
        userService.addUser(users);
    }
    @GetMapping("/enrolled")
    public List<CourseRegistration> getAllCourse(){
        return courseService.getAllCourse();
    }

}
