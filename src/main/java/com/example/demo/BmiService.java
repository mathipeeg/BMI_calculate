package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BmiService {

    @Autowired
    BmiRepository bmiRepository;

    public void updateInfo(User user) {
        user.setHeight(180);
        bmiRepository.updateInfo(user);
    }

    public double calculateBMI(User user) {
        //udregnes en masse bmi shit
        //Leg lidt med infoen
        String weight = user.getWeight();
        //split weight på enten , eller .
        int height = user.getHeight();
        double bmi = Integer.parseInt(weight) + height;
        return bmi;
    }
}
