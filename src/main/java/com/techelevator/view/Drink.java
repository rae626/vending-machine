package com.techelevator.view;

public class Drink extends Items {
    private String type;
    private int amount;

    public Drink(String ID, String name, double price, String type) {
        super(ID, name, price);
        this.amount = 5;
        this.type = type;
    }
    @Override
    public String printMessage() {
        return "Glug Glug, Yum!";
    }
}