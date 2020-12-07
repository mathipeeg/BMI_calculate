package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name = "user") // (name = "owners") er krævet.
public class User {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column (name = "id")

    @Column (name = "weight") //er IKKE krævet
    private double weight;  // SKAL være i camel-case (firstName)

    @Column (name = "height") //er IKKE krævet
    private double height;  // SKAL være i camel-case (firstName)

    public User(Long id, double weight, double height) {
        this.id = id;
        this.weight = weight;
        this.height = height;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
