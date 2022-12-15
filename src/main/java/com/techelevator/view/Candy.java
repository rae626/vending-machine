package com.techelevator.view;

public class Candy extends Items{
    private String type;
    private int amount;

    public Candy(String id, String name, double price, String type) {
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
        return "Munch Munch, Yum!";
    }


}
