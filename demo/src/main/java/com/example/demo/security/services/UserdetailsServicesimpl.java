package com.example.demo.security.services;

import com.example.demo.entities.Users;
import com.example.demo.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserdetailsServicesimpl implements UserDetailsService
{
    @Autowired
    UserRepository userRepository;

    @Override

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepository.findAllByUsername(username).orElseThrow(()->new UsernameNotFoundException("User not found with username = "+username));
        return UserDetailImpl.build(users);
    }
}
