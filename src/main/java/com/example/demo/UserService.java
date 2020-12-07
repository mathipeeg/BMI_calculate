package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends CrudService<User, Long>{
    public double calculateBMI();

}
