package com.techelevator;

import java.util.Scanner;

public class Money {

    public static double totalMoney = 0.0;
    public static double remainingMoney = 0.0;
    final double FIVE_DOLLAR_BILL = 5.00;
    final double ONE_DOLLAR_BILL = 1.00;

    final static int QUARTER = 25;
    final static int DIME = 10;
    final static int NICKEL = 5;


    public Money() {
    }

    public double getFIVE_DOLLAR_BILL() {
        return FIVE_DOLLAR_BILL;
    }

    public double getONE_DOLLAR_BILL() {
        return ONE_DOLLAR_BILL;
    }

    public double getQUARTER() {
        return QUARTER;
    }

    public double getDIME() {
        return DIME;
    }

    public double getNICKEL() {
        return NICKEL;
    }

    public static void moneyInserted(){
        Scanner input = new Scanner(System.in); //created scanner to capture system input.
        System.out.println("Please Insert Money"); //prints out instruction for user.
        totalMoney = input.nextDouble(); // double totalMoney is equal to the nextLine of system input.
        input.nextLine(); // adds a newline char to advance the system input.
    }
    public static int[] changeDue(double totalMoneyReceived, double totalAmountOwed){
        final int[] coins = {NICKEL,DIME,QUARTER};  //Constant int[] called coins to hold the values of the coins
        int change = (int)((totalMoneyReceived - totalAmountOwed) * 100); //calculates the amount of change and casts the result of it to an int
        int[] coinsReturned = new int[3]; // creates a new int[] called coinsReturned and sets it to hold 3 values.
        //double changeOwed = 0.0;
        //changeOwed = totalMoneyReceived - totalAmountOwed;
        for(int i = 5; i>0; i++){  //for i starts at pos 2, i is greater than or equal to 0, decrement i by 1.
            coinsReturned[i] = change / coins[i]; //coinsReturned[] position i = change divided by the value of coins array position i.
            change %= coins[i]; //change is mod or equal to coins array position i
        }
        return coinsReturned; //return the array coinsReturned[]
    }
}
