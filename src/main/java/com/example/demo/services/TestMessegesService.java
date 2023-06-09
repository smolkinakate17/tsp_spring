package com.example.demo.services;

import com.example.demo.models.TestMesseges;
import com.example.demo.models.TestTheme;
import com.example.demo.models.TestUsers;
import com.example.demo.repository.TestMessegesRepository;
import com.example.demo.repository.TestUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TestMessegesService {
    private final TestMessegesRepository testMessegesRepository;
    private final TestUserRepository testUserRepository;
    public List<TestMesseges> getAllMesseges(){
        return testMessegesRepository.findAll();
    }
    public TestUsers getUser(TestMesseges messeges){
        return messeges.getUser();
    }


    public TestMesseges getMessegeById(Integer id){

        return testMessegesRepository.findById(id).orElse(null);
    }
    public TestUsers getUserByMessegeId(Integer id){
        return getMessegeById(id).getUser();
    }
    public TestTheme getThemeByMessegeId(Integer id){
        return getMessegeById(id).getTheme();
    }


    public List<TestMesseges> getMessegesByThemeId(Integer id){
        return testMessegesRepository.findByTheme_Id(id);
    }
    public void saveMessege(TestMesseges messeges, Principal principal){
        messeges.setUser(getUserByPrincipal(principal));
        testMessegesRepository.save(messeges);
    }
    public void deleteMessege(Integer id){
        TestMesseges messeges=getMessegeById(id);
        testMessegesRepository.delete(messeges);
    }


    public TestUsers getUserByPrincipal(Principal principal) {
        if (principal == null) return new TestUsers();
        return testUserRepository.findTestUsersByLogins(principal.getName());
    }

}
