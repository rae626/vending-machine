package com.techelevator.view;


import com.techelevator.Money;
import com.techelevator.VendingMachineCLI;
import org.junit.Assert;
import org.junit.Test;
import java.io.File;


public class SelectionTest {

  @Test
  public void testForAddingItemsToInventory(){
    File newFile = new File("./testInventory.txt");

    VendingMachineCLI.addItemsToInventory(newFile);
    int expected = 4;
    Assert.assertEquals(expected,VendingMachineCLI.getInventory().size());
  }

  @Test
    public void testSubtractingItemWhenVended(){
    Money.setTotalMoney(1);
    Candy testCandy = new Candy("G5","testCandy",0.99,"Candy",0);
    VendingMachineCLI.getInventory().add(testCandy);
    SecondMenu.addItemToCart(0);
    int expected = 4;
    Assert.assertEquals(expected, VendingMachineCLI.getInventory().get(0).getAmount());
  }

  @Test
  public void testValidItem(){
//    String testRealId = "a1";
//    SecondMenu.selectProduct(testRealId);
    System.out.println("\u001B[33m" + "Test");
  }

}
