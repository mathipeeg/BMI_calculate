package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

@Controller
public class HomeController {

//test

    private UserService userService; // Spring vil selv komme med objektet hertil

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping({"/"})
    public String index(Model model){
        return "index";
    }

    @RequestMapping({"/chart"})
    public String scale(){return "chart";}

    @RequestMapping({"/what-is"})
    public String what(){
        return "what-is";
    }

    @RequestMapping({"/input-page"})
    public String input(){
        return "input";
    }

    @RequestMapping({"/updateInfo"})
    public String updateInfo(@ModelAttribute User user){
        userService.save(user);
        return "redirect:/result";
    }

    @RequestMapping({"/jokes"})
    public String jokes(){return "jokes";}

    @RequestMapping({"/result"})
    public String showResult(ModelMap model){
        model.addAttribute("bmi", userService.calculateBMI());
        return "result";
    }
}
