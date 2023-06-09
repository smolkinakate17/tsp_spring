package com.example.demo.controllers;

import com.example.demo.models.TestMesseges;
import com.example.demo.models.TestUsers;
import com.example.demo.services.TestMessegesService;
import com.example.demo.services.TestUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TestUserController {
    private final TestUserService testUserService;

    @GetMapping("/login")
    public String login(){
        return"/login";
    }

    @GetMapping("/registration")
    public String registration(){
        return"/registration";
    }


    @PostMapping("/registration")
    public String createUser(TestUsers user,Model model){
        if(!testUserService.createUser(user)){
            model.addAttribute("errorMessege","Пользователь с логином "+user.getLogins()+" уже существует");
            return "registration";
        }
        return "redirect:/login";
    }
    /*@GetMapping("/logout")
    public String logout(Model model){
        TestUsers user=null;
        model.addAttribute("user",user);
        return "index";
    }*/

    @GetMapping("/hello")
    public String securityUrl(){
        return "hello";
    }

    @GetMapping("/user/{id}")
    public String userInfo(@PathVariable Integer id,Model model){
        model.addAttribute("user",testUserService.getTestUserById(id));
        model.addAttribute("messeges",testUserService.getTestMessegesByUserId(id));
        return "user-info";
    }


}
