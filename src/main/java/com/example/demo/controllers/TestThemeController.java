package com.example.demo.controllers;

import com.example.demo.models.TestMesseges;
import com.example.demo.models.TestTheme;
import com.example.demo.models.TestUsers;
import com.example.demo.services.TestMessegesService;
import com.example.demo.services.TestThemeService;
import com.example.demo.services.TestUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TestThemeController {
    private final TestThemeService testThemeService;
    private final TestMessegesService testMessegesService;

    @GetMapping("/")
    public String products(@RequestParam(name = "name", required = false) String name, Model model,Principal principal) {
        model.addAttribute("products", testThemeService.getTestThemeListByName(name));
        model.addAttribute("user",testMessegesService.getUserByPrincipal(principal));
        return "index";
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Integer id, Model model,Principal principal) {
        model.addAttribute("product", testThemeService.getThemeById(id));
        model.addAttribute("messeges",testMessegesService.getMessegesByThemeId(id));
        model.addAttribute("user",testMessegesService.getUserByPrincipal(principal));
        return "themepage";
    }

    @GetMapping("/newtheme")
    public String newTheme(){
        return "addtheme";
    }
    @PostMapping("/product/create")
    public String createProduct(TestTheme theme) {

        testThemeService.saveTheme(theme);
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        testThemeService.deleteThemeById(id);
        return "redirect:/";
    }

    @PostMapping("/product/messege/create/{id}")
    public String createMessage(TestMesseges messeges,@PathVariable Integer id, Principal principal){
        TestTheme theme =testThemeService.getThemeById(id);
        messeges.setTheme(theme);
        testMessegesService.saveMessege(messeges,principal);
        return "redirect:/product/{id}";

    }

    @PostMapping("/product/messege/{mesid}/delete/{id}/{userid}")
    public String deleteMessege(@PathVariable Integer mesid,@PathVariable Integer id, @PathVariable Integer userid){

        testMessegesService.getMessegeById(mesid).setUser(null);
        testMessegesService.getMessegeById(mesid).setTheme(null);
        testMessegesService.getMessegeById(mesid).setText(null);
        testMessegesService.deleteMessege(mesid);

        return "redirect:/product/{id}";
    }

   /* @GetMapping("/product/{id}")
    public String getMesseges(@PathVariable Integer id, Model model){
        model.addAttribute("messeges",testMessegesService.getMessegesByThemeId(id));
        return "product-info";
    }*/
}
