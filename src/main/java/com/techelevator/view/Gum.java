package com.techelevator.view;

public class Gum extends Items {


    private String type;
    private int amount;

    public Gum(String id, String name, double price, String type) {
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String printMsg() {
        return "Chew Chew, Yum!";
    }

}
