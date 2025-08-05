package com.example.course.enrollment.system.service;

import com.example.course.enrollment.system.model.Users;
import com.example.course.enrollment.system.repository.UserDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder(12);
    @Autowired
    UserDetailRepo userDetailRepo;
    public void addUser(Users users) {
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        userDetailRepo.save(users);
    }
}
