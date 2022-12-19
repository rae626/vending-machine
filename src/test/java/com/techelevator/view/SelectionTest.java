package com.techelevator.view;

import com.techelevator.Money;
import com.techelevator.VendingMachineCLI;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    List<Items> testList = new ArrayList<>();
    VendingMachineCLI.getInventory().add(testCandy);
    SecondMenu.addItemToCart(0);
    int expected = 4;
    Assert.assertEquals(expected, VendingMachineCLI.getInventory().get(0).getAmount());
  }


}
