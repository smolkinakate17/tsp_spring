package com.example.demo.services;

import com.example.demo.repository.TestUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomTestUserDetailsService implements UserDetailsService {

    private final TestUserRepository testUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return testUserRepository.findTestUsersByLogins(username);
    }
}
