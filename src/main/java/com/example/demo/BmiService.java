package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class BmiService {

    @Autowired
    BmiRepository bmiRepository;

    public void updateInfo(User user) {
        String weightString = user.getWeight();
        String newWeightString;
        if (weightString.contains(",")){
            String[] weightSplit = weightString.split(",");
            newWeightString = weightSplit[0] + "." + weightSplit[1];
            user.setWeight(newWeightString);
        }
        bmiRepository.updateInfo(user);
    }

    public String calculateBMI() {
        DecimalFormat df2 = new DecimalFormat("#.##");
        User user = bmiRepository.getUser();
        double weight = Double.parseDouble(user.getWeight());
        double height = user.getHeight() / 100;
        double bmi = weight / (Math.pow(height, 2));
        return df2.format(bmi);
    }

    public void userExists() {
        User user = bmiRepository.getUser();
        if (user == null){
            bmiRepository.createUser();
        }
    }
}
