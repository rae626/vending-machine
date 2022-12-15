package com.techelevator.view;


import com.techelevator.Money;
import com.techelevator.VendingMachineCLI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static com.techelevator.VendingMachineCLI.inventory;

public class SecondMenu {

    private static final String MENU_OPTION_FEEDMONEY = "Feed Money";
    private static final String MENU_OPTION_SELECT = "Select Product";
    private static final String MENU_OPTION_FINISH = "Finish Transaction";

    private static final String[] MENU_OPTIONS = {MENU_OPTION_FEEDMONEY, MENU_OPTION_SELECT, MENU_OPTION_FINISH};

    public static List<Items> Cart = new ArrayList<>();

    private Menu menu2;

    public SecondMenu(Menu menu) {
        this.menu2 = menu;
    }

    public void run2() {
        while (true) {
            String choice = (String) menu2.getChoiceFromOptions(MENU_OPTIONS);

            if (choice.equals(MENU_OPTION_FEEDMONEY)) {
                Money.moneyInserted();

            } else if (choice.equals(MENU_OPTION_SELECT)) {
                selectProduct();

            } else if (choice.equals(MENU_OPTION_FINISH)) {
                finalizeTrans();
            }

        }
    }

    public static void selectProduct(){
        //prints inventory
        VendingMachineCLI.printInventory();

        //Asks for users product choice
        Scanner prodChoice = new Scanner(System.in);
        System.out.println("---------------------------------");
        System.out.print("Select Product: ");
        String choice = prodChoice.nextLine();

        //Loops the ID string and matches it to an Item object's getID method
        for(int i = 0; i < choice.length();i++)
            if(choice.equals(inventory.get(i).getId())){
                if(inventory.get(i).getPrice() < Money.totalMoney){
                    if(inventory.get(i).getAmount() > 0){

                        Cart.add(inventory.get(i));
                        inventory.get(i).setAmount(inventory.get(i).getAmount()-1);

                        System.out.println("Cart size is: "+Cart.size());

                        for(int p = 0; p < Cart.size();p++){
                            Money.remainingMoney = Money.totalMoney - Cart.get(p).getPrice();
                            System.out.println(Cart.get(p).getName()+" "+Cart.get(p).getPrice()+" Balance remaining: $"+Money.remainingMoney);
                            System.out.println(Cart.get(p).printMsg());
                        }


                    } else {
                        System.err.println("Amount of Item is 0");
                    }

                } else {
                    System.err.println("Insufficient Funds");
                }



                //**DEBUG** to check how much is left of the Item stock after the selection
                //System.out.println(inventory.get(i).getAmount());

            }

    }


    public static void finalizeTrans(){
        //logger log
        //dispense change
        System.out.println(Arrays.toString(Money.changeDue(Money.remainingMoney,Money.totalMoney )));




    }


}
