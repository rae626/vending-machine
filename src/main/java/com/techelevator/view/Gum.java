package com.techelevator.view;

public class Gum extends Items {
    private String type;
    private int amount;

    public Gum(String ID, String name, double price, String type) {
        super(ID, name, price);
        this.amount = 5;
        this.type = type;
    }
    @Override
    public String printMessage() {
        return "Chew Chew, Yum!";
    }
}
