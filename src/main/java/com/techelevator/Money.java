package com.techelevator;

import java.util.Scanner;

public class Money {

    final double FIVE_DOLLAR_BILL = 5.00;
    final double ONE_DOLLAR_BILL = 1.00;

    final double QUARTER = .25;
    final double DIME = .10;
    final double NICKEL = .05;


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

    public static void moneyInserted(String[] args){
       double totalMoney = 0.0;
        Scanner input = new Scanner(System.in);
        System.out.println("Please Insert Money");
        totalMoney = input.nextDouble();
    }
    public int[] changeDue(double totalMoneyReceived , double totalAmountOwed){
        final int[] coins = {5,10,25};
        int change = (int)(totalMoneyReceived - totalAmountOwed) * 100;
        int[] coinsReturned = new int[3];
        //double changeOwed = 0.0;
        //changeOwed = totalMoneyReceived - totalAmountOwed;
        for(int i = 5; i>0; i--){
            coinsReturned[i] = change / coins[i];
            change %= coins[i];

        }

        return coinsReturned;
    }


}
