package com.techelevator;

import com.techelevator.view.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT =	"Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };
 	private static List<Items> inventory = new ArrayList<>();
	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			addItemsToInventory();

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items

          printInventory();

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
					menu2();
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();

	}

	public static void menu2(){
		Menu pMenu = new Menu(System.in, System.out);
		SecondMenu second = new SecondMenu(pMenu);
		second.run2();
	}

	public static void addItemsToInventory(){

		File file = new File("vendingmachine.csv");
		try(Scanner inventoryScanner = new Scanner(file)){

			while(inventoryScanner.hasNextLine()){
				String line = inventoryScanner.nextLine();
				String[] bucket = line.split("\\|");
				String q = bucket[0];
				String w = bucket[1];
				double e = Double.parseDouble(bucket[2]);
				String r = bucket[3];


				if(r.equals("Chip")){
					Chips newChips = new Chips(q,w,e,r);
					inventory.add(newChips);
				} else if (r.equals("Candy")){
					Candy newCandy = new Candy(q,w,e,r);
					inventory.add(newCandy);
				} else if (r.equals("Drink")){
					Drink newDrink = new Drink(q,w,e,r);
					inventory.add(newDrink);
				} else if (r.equals("Gum")){
					Gum newGum = new Gum(q,w,e,r);
					inventory.add(newGum);
				}


			}

			System.out.println("There are "+ inventory.size() + "Items in the Inventory");


		}catch(FileNotFoundException fnaf){
			System.err.println("File was NOT FOUND...");
			System.out.println("Now exiting...");
			System.exit(1);
		}
	}
	public static void printInventory() {
		for (int i = 0; i < inventory.size(); i++) {
			System.out.println(inventory.get(i).getID() + " " + inventory.get(i).getName());
		}
	}
}

