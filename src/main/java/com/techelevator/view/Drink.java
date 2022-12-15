package com.techelevator.view;

public class Drink extends Items {
    private String type;
    private int amount;

    public Drink(String id, String name, double price, String type) {
        super(id, name, price);
        this.type = type;
        this.amount = 5;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String printMsg(){
        return "Glug Glug, Yum!";
    }
}