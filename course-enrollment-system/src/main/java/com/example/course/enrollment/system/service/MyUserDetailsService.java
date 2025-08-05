package com.example.course.enrollment.system.service;

import com.example.course.enrollment.system.model.UserPrincipal;
import com.example.course.enrollment.system.model.Users;
import com.example.course.enrollment.system.repository.UserDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserDetailRepo userDetailRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Users user=  userDetailRepo.getByUsername(username);
       if(user==null)
       {
           throw new UsernameNotFoundException("user not found");
       }
       return  new UserPrincipal(user);
    }
}
