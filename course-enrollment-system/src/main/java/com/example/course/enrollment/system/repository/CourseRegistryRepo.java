package com.example.course.enrollment.system.repository;

import com.example.course.enrollment.system.model.CourseRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRegistryRepo extends JpaRepository<CourseRegistration,Integer> {
}
