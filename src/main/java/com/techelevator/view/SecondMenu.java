package com.techelevator.view;

import com.techelevator.Money;
import com.techelevator.VendingMachineCLI;

public class SecondMenu {
    private static final String PURCHASE_MENU_FEED_MONEY = "Feed money";
    private static final String PURCHASE_MENU_SELECT_PRODUCT = "Select product";
    private static final String PURCHASE_MENU_FINISH_TRANSACTION =	"Finish transaction";
    private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_FEED_MONEY, PURCHASE_MENU_SELECT_PRODUCT, PURCHASE_MENU_FINISH_TRANSACTION };
    private static double balance =0;

    public static double getBalance() {
        return balance;
    }

    public static void setBalance(double balance) {
        SecondMenu.balance = balance;
    }

    private Menu menu2;

    public SecondMenu(Menu menu2) {
        this.menu2 = menu2;
    }
    public void run2() {
        System.out.println("Current money provided: $"+ getBalance());
        while (true) {
            String choice = (String) menu2.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

            if (choice.equals(PURCHASE_MENU_FEED_MONEY)) {
                // Feed money
                Money.moneyInserted();
            } else if (choice.equals(PURCHASE_MENU_SELECT_PRODUCT)) {
                // Select Product
                VendingMachineCLI.printInventory();
            }else if (choice.equals(PURCHASE_MENU_FINISH_TRANSACTION)) {
                // Finish transaction
            }
        }
    }
}
