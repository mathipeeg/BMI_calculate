package com.example.demo;

public class User {
    private int userId;
    private String weight;
    private double height;

    public User(int userId, String weight, double height) {
        this.userId = userId;
        this.weight = weight;
        this.height = height;
    }

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
