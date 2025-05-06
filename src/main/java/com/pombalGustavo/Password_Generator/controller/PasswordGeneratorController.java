package com.pombalGustavo.Password_Generator.controller;

import com.pombalGustavo.Password_Generator.model.PasswordOptions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PasswordGeneratorController {

    @GetMapping("/home")
    public String home(PasswordOptions passwordOptions, Model model) {

        return "home";
    }



}
