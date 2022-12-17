package com.techelevator.view;

public class Chips extends Items {

    private String type;
    private int amount;

    //Chips subclass constructor
    public Chips(String id, String name, double price, String type, int pos) {
        super(id, name, price, pos);
        this.type = type;
        this.amount = 5;
    }

    // ------ Setters and getters ------
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

    // ------ end of sets and gets -------


    @Override
    public String printMsg() {
        return "Crunch Crunch, Yum!";
    } // Overrides the Item printMsg method with its own version.

}
