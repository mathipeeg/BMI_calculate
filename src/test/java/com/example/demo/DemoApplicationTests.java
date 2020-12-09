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

import static org.junit.jupiter.api.Assertions.*;

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
    public void testSaveAndDeleteWorks(){
        //save
        int length_initial = userService.findAll().size();
        User user = new User();
        userService.save(user);
        int length_new = userService.findAll().size();
        assertNotEquals(length_initial, length_new);

        //delete
        userService.delete(user);
        int length_new_2 = userService.findAll().size();
        assertEquals(length_initial, length_new_2);
    }

    @Test
    public void testEditFunction(){
        Optional<User> user = userService.findById((long)1);
        double old_weight = user.get().getWeight();
        user.get().setWeight(100);

        userService.save(user.get());
        double new_weight = user.get().getWeight();
        assertNotEquals(old_weight, new_weight);
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
