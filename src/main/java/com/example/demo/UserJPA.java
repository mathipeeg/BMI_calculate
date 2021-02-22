package com.example.demo;

import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;

@Service
public class UserJPA implements UserService {
    private final UserRepository userRepository;

    public UserJPA(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Set<User> findAll() {
        Set<User> set = new HashSet<>();
        userRepository.findAll().forEach(set::add); // tilføjer alle elementer til set
        return set;
    }

    @Override
    public User save(User object) {
        return userRepository.save(object);
    }

    @Override
    public void delete(User object) {
        userRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        userRepository.deleteById(aLong);
    }

    @Override
    public Optional<User> findById(Long aLong) {
        return userRepository.findById(aLong);
    }

    @Override
    public double calculateBMI(){
        ArrayList<User> users = (ArrayList<User>) userRepository.findAll();
        User user = users.get(users.size()-1);
        DecimalFormat df = new DecimalFormat("###.##");
        return Double.parseDouble(df.format(user.getWeight()/(user.getHeight()*user.getHeight())));
    };
}
