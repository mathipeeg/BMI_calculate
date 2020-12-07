package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepo;

    @Test
    void contextLoads() {
    }

    @Test
    public void assertDatabaseIsNotEmpty(){
        assertNotNull(userService.findById((long)1));
    }

    @Test
    public void assertCalculateReturnsNotNull(){
        assertNotNull(userService.calculateBMI());
    }

    @Test
    public void assertCalculateWorks(){
        List<User> users = (List<User>) userRepo.findAll();
        User user = users.get(users.size()-1);
        DecimalFormat df = new DecimalFormat("###.##");
        double bmi = Double.parseDouble(df.format(user.getWeight()/(user.getHeight()* user.getHeight())));

        assertEquals(userService.calculateBMI(), bmi);
    }

}
