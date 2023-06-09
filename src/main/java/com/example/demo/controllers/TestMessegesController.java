package com.example.demo.controllers;

import com.example.demo.models.TestMesseges;
import com.example.demo.models.TestUsers;
import com.example.demo.services.TestMessegesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TestMessegesController {
    /*private final TestMessegesService testMessegesService;


   @GetMapping("/product/{id}")
   public String allMesseges(@PathVariable Integer id, Model model){
       model.addAttribute("messages",testMessegesService.getMessegesByThemeId(id));
       return "product-info";//здесь возвращаем конкретный макет странички чтобы на макете можно было использовать messages
   }

   @PostMapping("/messege/create")
   public String createMessage(TestMesseges messeges){
       testMessegesService.saveMessege(messeges);
       return "redirect:/product/{id}";
   }*/

}
