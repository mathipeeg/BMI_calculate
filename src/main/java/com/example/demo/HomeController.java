package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    BmiService bmiService;
    @Autowired
    BmiRepository bmiRepository;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/input-page")
    public String input(){
        return "input-page";
    }

    @PostMapping("/updateInfo")
    public String updateInfo(@ModelAttribute User user){
        bmiService.updateInfo(user);
        return "redirect:/input-page";
    }

    @GetMapping("/result")
    public String showResult(ModelMap model){
        User user = bmiRepository.getUser();
        double bmi = bmiService.calculateBMI(user);
        model.addAttribute("bmi", bmi);
        return "result";
    }
}
