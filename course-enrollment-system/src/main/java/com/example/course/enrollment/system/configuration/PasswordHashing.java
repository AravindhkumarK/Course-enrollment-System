package com.example.course.enrollment.system.configuration;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHashing {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
        String password = "Admin1234";
        String encode = bCryptPasswordEncoder.encode(password);
        System.out.println(encode);

    }

}
