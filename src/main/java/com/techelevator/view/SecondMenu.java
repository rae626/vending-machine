package com.techelevator.view;


import com.techelevator.Money;
import com.techelevator.VendingMachineCLI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static com.techelevator.VendingMachineCLI.inventory;

public class SecondMenu {

    private static final String MENU_OPTION_FEEDMONEY = "Feed Money"; //created a constant String for 1st option.
    private static final String MENU_OPTION_SELECT = "Select Product";  // created a constant String for 2nd option.
    private static final String MENU_OPTION_FINISH = "Finish Transaction"; // created a constant String for 3rd option.

    private static final String[] MENU_OPTIONS = {MENU_OPTION_FEEDMONEY, MENU_OPTION_SELECT, MENU_OPTION_FINISH}; //created a constant String[] to hold the menu options.

    public static List<Items> Cart = new ArrayList<>(); // added a List to hold Item objects like candy,gum,drink,chips

    private Menu menu2; //created a Menu object called menu2

    public SecondMenu(Menu menu) {
        this.menu2 = menu;
    }

    //menu2 Constructor
    public void run2() { //run2 is the second menu when you select purchase from the main menu
        while (true) { //while the condition is true
            String choice = (String) menu2.getChoiceFromOptions(MENU_OPTIONS); // sets String choice equal to String casted result of the method menu2.getChoiceFromOptions

            if (choice.equals(MENU_OPTION_FEEDMONEY)) { //if user selects first option...
                Money.moneyInserted(); //calls the static method from the money class to add money

            } else if (choice.equals(MENU_OPTION_SELECT)) { //if user selects the second option...
                selectProduct(); //calls the selectProduct method within this class

            } else if (choice.equals(MENU_OPTION_FINISH)) { //if user selects the third option...
                finalizeTrans(); //calls the finalizeTrans method
            }

        }
    }

    public static void selectProduct(){
        //prints inventory
        VendingMachineCLI.printInventory(); //calls the printInventory method from VendingMachineCLI.

        //Asks for users product choice
        Scanner prodChoice = new Scanner(System.in); //creates a Scanner obj called prodChoice.
        System.out.println("---------------------------------"); // to establish a border.
        System.out.print("Select Product: ");  //prints out instruction.
        String choice = prodChoice.nextLine(); //Sets a String called choice to equal the captured input from prodChoice.

        //Loops the ID string and matches it to an Item object's getID method
        for(int i = 0; i < choice.length();i++) // for i is equal to 0 and i is less than the size of inventory
            if(choice.equals(inventory.get(i).getId())){ //if choice is equal to the i position in the List inventory then ...
                if(inventory.get(i).getPrice() < Money.totalMoney){  //if i position in inventory method getPrice is less than the static Var totalMoney....
                    if(inventory.get(i).getAmount() > 0){  // if i position in inventory method getAmount is greater than 0...

                        Cart.add(inventory.get(i)); // add the i position of inventory to the cart list.
                        inventory.get(i).setAmount(inventory.get(i).getAmount()-1); // the i postion in inventory setAmount method gets called and sets it to equal one less.

                        //**Debug**
                        //System.out.println("Cart size is: "+Cart.size());

                        for(int p = 0; p < Cart.size();p++){  //for int p is = 0 and p is less than the size of cart increment p by 1.
                            Money.remainingMoney = Money.totalMoney - Cart.get(p).getPrice(); //sets the static var remainingMoney to equal the result of Static var totalmoney and the price of the item selected
                            System.out.println(Cart.get(p).getName()+" "+Cart.get(p).getPrice()+" Balance remaining: $"+Money.remainingMoney); // prints the the item bought and the price along with the balance remaining
                            System.out.println(Cart.get(p).printMsg()); // prints out the items message
                        }


                    } else {  //if the amount of the item is equal to 0
                        System.err.println("Amount of Item is 0"); // prints out the error
                    }

                } else { //if the funds are less than what the item costs
                    System.err.println("Insufficient Funds"); // prints out the error
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
