package com.pombalGustavo.Password_Generator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PasswordGeneratorController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("message", "Bem-vindo ao Thymeleaf!");
        return "home";
    }
}
