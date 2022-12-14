package com.techelevator.view;

public class Candy extends Items{
    private String type;
    private int amount;

    public Candy(String ID, String name, double price, String type) {
        super(ID, name, price);
        this.amount = 5;
        this.type = type;

    }
    @Override
    public String printMessage(){
        return "Munch Munch, Yum!";
    }
}
