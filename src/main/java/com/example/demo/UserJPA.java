package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service  // den gør, at en instans fra denne klasse bliver oprettet, og
// sat ind i OwnerController via konstruktor.
public class UserJPA implements UserService {
    private final UserRepository userRepository;

    // Spring vil *selv* oprette en instans, som implementerer OwnerRepository
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
}
