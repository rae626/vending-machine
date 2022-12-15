package com.techelevator.view;

public class Items {

    private String id;
    private String name;
    private double price;
    private int amount;

    //Item superClass Constructor
    public Items(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // ----- Setters and getters -----------
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    // ------ end of sets and gets ------

    public String printMsg(){
        return "mmm, mmm this Item is good";
    } // printMsg method to output message and allows subClasses to override the parent method.
}
