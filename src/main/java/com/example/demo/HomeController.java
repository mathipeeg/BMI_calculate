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
        bmiService.userExists();
        return "index";
    }

    @GetMapping("/chart")
    public String scale(){return "chart";}

    @GetMapping("/what-is")
    public String what(){
        return "what-is";
    }

    @GetMapping("/input-page")
    public String input(){
        return "input";
    }

    @PostMapping("/updateInfo")
    public String updateInfo(@ModelAttribute User user){
        bmiService.updateInfo(user);
        return "redirect:/result";
    }
    @GetMapping("/jokes")
    public String jokes(){return "jokes";}

    @GetMapping("/result")
    public String showResult(ModelMap model){
        model.addAttribute("bmi", bmiService.calculateBMI());
        return "result";
    }
}
