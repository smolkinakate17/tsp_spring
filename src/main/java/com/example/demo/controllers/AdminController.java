package com.example.demo.controllers;

import com.example.demo.models.TestUsers;
import com.example.demo.models.enums.Role;
import com.example.demo.services.TestUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminController {
    private final TestUserService userService;

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("users", userService.getTestUsersList());
        return "admin";
    }

    @PostMapping("/admin/user/ban/{id}")
    public String userBan(@PathVariable("id") Integer id) {
        userService.banUser(id);
        return "redirect:/admin";
    }

/*    @GetMapping("/admin/user/edit/{user}")
    public String userEdit(@PathVariable("user") TestUsers user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "user-edit";
    }*/

    @PostMapping("/admin/user/edit/{id}")
    public String userEdit(@PathVariable("id") Integer id) {
        userService.changeUserRoles(id);
        return "redirect:/admin";
    }
}
