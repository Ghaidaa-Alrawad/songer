package com.songer.songerWebApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

//    @ResponseBody
    @GetMapping("/hello")
    //hello world route
    public String welcomeHello(Model viewName) {
        viewName.addAttribute("name", "Ghaidaa");
        return "hello.html";
    }

}
