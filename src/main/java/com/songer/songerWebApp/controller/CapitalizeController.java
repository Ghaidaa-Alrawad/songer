package com.songer.songerWebApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CapitalizeController {
    @GetMapping("/capitalize/{word}")
    public String capitalize(Model userWord , @PathVariable String word){
        userWord.addAttribute("word" , word.toUpperCase());
        return "capitalize.html";
    }
}
