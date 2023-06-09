package com.example.demo.services;

import com.example.demo.models.TestTheme;
import com.example.demo.models.TestUsers;
import com.example.demo.repository.TestThemeRepository;
import com.example.demo.repository.TestUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class TestThemeService {
    private final TestThemeRepository testThemeRepository;
    private final TestUserRepository testUserRepository;

    public List<TestTheme> getTestThemeListByName(String name){
        if(name!=null) return testThemeRepository.findTestThemeByName(name);
        else return testThemeRepository.findAll();
    }
    public TestTheme getThemeById(Integer id){
        return testThemeRepository.findById(id).orElse(null);
    }
    public void saveTheme(TestTheme theme){


        testThemeRepository.save(theme);
    }
    public TestUsers getUserByPrincipal(Principal principal) {
        if (principal == null) return new TestUsers();
        return testUserRepository.findTestUsersByLogins(principal.getName());
    }
    public void deleteThemeById(Integer id){
        testThemeRepository.deleteById(id);
    }
}
