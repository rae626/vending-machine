package com.techelevator;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class MoneyTest extends TestCase {

    public void testMoneyInserted() {

        Money.setTotalMoney(5); //updates the value to the totalMoney variable in the Money class

        Assert.assertEquals(5,Money.totalMoney,0); //this will test the 2 values to make sure they are the same if they are the test will pass
    }
@Test
    public void testChangeDue() {

       String constantResult = "Quarters: 4 Dimes: 0 Nickels: 0";  //gives a constant to test against


       Assert.assertEquals(constantResult, Money.changeDue(1)); //runs a comparison to the constant and calls the function with its parameter to return a string
                                                                                 // if the returned value is the same as the constant test will pass.

    }



}