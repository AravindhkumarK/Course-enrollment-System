package com.example.course.enrollment.system.service;

import com.example.course.enrollment.system.model.Course;
import com.example.course.enrollment.system.model.CourseRegistration;
import com.example.course.enrollment.system.repository.CourseRegistryRepo;
import com.example.course.enrollment.system.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepo courseRepo;

    @Autowired
    CourseRegistryRepo courseRegistryRepo;

    public List<Course> getAllDetails() {
        return courseRepo.findAll();

    }

    public List<CourseRegistration> getAllCourse() {
        return courseRegistryRepo.findAll();
    }

    public void enrollCourse(String name, String email, String courseName) {
        courseRegistryRepo.save(new CourseRegistration(name,email,courseName));
    }
}
