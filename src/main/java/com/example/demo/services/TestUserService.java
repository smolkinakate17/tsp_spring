package com.example.demo.services;

import com.example.demo.models.TestMesseges;
import com.example.demo.models.TestUsers;
import com.example.demo.models.enums.Role;
import com.example.demo.repository.TestUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class TestUserService {
    private final TestUserRepository testUserRepository;
    private final PasswordEncoder passwordEncoder;

    public List<TestUsers> getTestUsersList() {
        return testUserRepository.findAll();
    }

    public boolean createUser(TestUsers user){
        String logins=user.getLogins();
        if(testUserRepository.findTestUsersByLogins(logins)!=null){
            return false;
        }
        user.setActive(true);
        user.setPasswords(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.ROLE_USER);
        Set<Role> roleSet=user.getRoles();
        user.setRoles(roleSet);
        testUserRepository.save(user);
        return true;
    }


    public void  saveTestUsers(TestUsers user){
       log.info("Saving new {}", user);
        testUserRepository.save(user);
    }
    public void deleteTestUsers(Integer id){
        log.info("Deleting {}", id);
        testUserRepository.deleteById(id);
    }
    public TestUsers getTestUserById(Integer id){
        return testUserRepository.findById(id).orElse(null);
    }
    public List<TestMesseges> getTestMessegesByUserId(Integer id){
        return getTestUserById(id).getMesseges();
    }
    public void addNewMesseges(TestMesseges messeges,Integer id){
        TestUsers user=getTestUserById(id);
        testUserRepository.deleteById(id);
        user.getMesseges().add(messeges);
        testUserRepository.save(user);
    }

    public void banUser(Integer id) {
        TestUsers user = testUserRepository.findById(id).orElse(null);
        if (user != null) {
            if (user.isActive()) {
                user.setActive(false);

            } else {
                user.setActive(true);

            }
        }
        testUserRepository.save(user);
    }

    public void changeUserRoles(Integer id) {
        TestUsers user=getTestUserById(id);
        Set<Role> userRole=user.getRoles();
        if(userRole.contains(Role.ROLE_USER)){
            userRole.clear();
            userRole.add(Role.ROLE_ADMIN);
            user.setRoles(userRole);
        }
        else if(userRole.contains(Role.ROLE_ADMIN)){
            userRole.clear();
            userRole.add(Role.ROLE_USER);
            user.setRoles(userRole);
        }
        testUserRepository.save(user);
    }

}
