package com.honeybadgerworks.io.resumeportal.service;

import com.honeybadgerworks.io.resumeportal.domain.ResumePortalUserDetails;
import com.honeybadgerworks.io.resumeportal.domain.User;
import com.honeybadgerworks.io.resumeportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResumePortalUserDetailsService implements UserDetailsService {

    @Autowired UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUserName(userName);
        userOptional.orElseThrow(()-> new UsernameNotFoundException("User with name :" + userName + " Not Found"));
        return userOptional.map(ResumePortalUserDetails::new).get();
    }
}
