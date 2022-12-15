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
	private static final String MAIN_MENU_OPTION_Exit = "Exit";

	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_Exit };

	public static List<Items> inventory = new ArrayList<>();

	public static List<Items> getInventory() {
		return inventory;
	}

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {

		addItemsToInventory();

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				printInventory();

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				menu2();

			}else if (choice.equals(MAIN_MENU_OPTION_Exit)) {
				System.exit(1);
			}

		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}

	public static void menu2(){
		Menu menu2 = new Menu(System.in, System.out);
		SecondMenu second = new SecondMenu(menu2);
		second.run2();
	}

	public static void addItemsToInventory(){

		File file = new File("vendingmachine.csv");  //creates a file obj to refrence vendingMachine.csv.
		try(Scanner inventoryScanner = new Scanner(file)){   //creates scanner obj to scan the csv file.

			while(inventoryScanner.hasNextLine()){   //while the csv file has a nextline.
				String line = inventoryScanner.nextLine();  // assign that line of txt to a string var named line.
				String[] bucket = line.split("\\|");  //create a String[] called bucket and add the result of line split by the "|".
				String q = bucket[0];  //assigns the 0 position of i to String q which is the ID.
				String w = bucket[1];  //assigns the 1 position of i to String w which is the Name.
				double e = Double.parseDouble(bucket[2]); //assigns the 2 position of i to Double e which is the Price.
				String r = bucket[3]; //assign the 3 position of i to String r which is the type of item it is.

				switch (r) {  //
					case "Chip":  // the String r equals type chip.
						Chips newChips = new Chips(q, w, e, r); // create a chip object along with id name and price.
						inventory.add(newChips); // add the chip item to inventory.
						break; //break from switch.
					case "Candy": //the String r equals type candy.
						Candy newCandy = new Candy(q, w, e, r); // // create a candy object along with id name and price.
						inventory.add(newCandy); //add the candy item to inventory.
						break; //break from switch.
					case "Drink": //the String r equals type drink.
						Drink newDrink = new Drink(q, w, e, r); // // create a drink object along with id name and price.
						inventory.add(newDrink); //add the candy item to inventory.
						break; //break from switch.
					case "Gum": //the String r equals type gum.
						Gum newGum = new Gum(q, w, e, r);  // create a gum object along with id name and price.
						inventory.add(newGum); // add the gum item to inventory.
						break; //break from switch
				}
			}

		}catch(FileNotFoundException fnaf){
			System.err.println("File was NOT FOUND...");
			System.out.println("Now exiting...");
			System.exit(1);
		}
	}

	public static void printInventory(){
		for (int i=0; i < inventory.size(); i++){
			System.out.println(inventory.get(i).getId() + " " + inventory.get(i).getName()+ " " + inventory.get(i).getPrice()+" ("+inventory.get(i).getAmount()+")");		}
	}



}

