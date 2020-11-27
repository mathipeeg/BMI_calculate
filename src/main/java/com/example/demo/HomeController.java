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

    private UserService userService; // Spring vil selv komme med objektet hertil

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping({"/"})
    public String index(Model model){
        Set<User> user = userService.findAll();
        model.addAttribute("user", user);
//        bmiService.userExists(); //todo this
        return "index";
    }

    @RequestMapping({"/chart.html"})
    public String scale(){return "chart";}

    @RequestMapping({"/what-is.html"})
    public String what(){
        return "what-is";
    }

    @RequestMapping({"/input-page.html"})
    public String input(){
        return "input";
    }

    @RequestMapping({"/updateInfo.html"})
    public String updateInfo(@ModelAttribute User user){
        userService.save(user);
        return "redirect:/result.html";
    }

    @RequestMapping({"/jokes.html.html"})
    public String jokes(){return "jokes";}

//    @RequestMapping({"/result.html"})
//    public String showResult(ModelMap model){
//        model.addAttribute("bmi", bmiService.calculateBMI()); //Todo this
//        return "result";
//    }
}
