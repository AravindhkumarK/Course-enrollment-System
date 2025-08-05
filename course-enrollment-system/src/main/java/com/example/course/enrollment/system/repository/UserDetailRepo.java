package com.example.course.enrollment.system.repository;

import com.example.course.enrollment.system.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepo extends JpaRepository<Users,Integer> {
    Users getByUsername(String username);
}
