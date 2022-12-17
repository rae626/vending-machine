package com.techelevator;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class MoneyTest {

    @Test
    public void testMoneyInserted() {

        Money.setTotalMoney(5); //updates the value to the totalMoney variable in the Money class

        Assert.assertEquals(5,Money.totalMoney,0); //this will test the 2 values to make sure they are the same if they are the test will pass
    }
@Test
public void testChangeDue() {

    String constantResult = "Quarters: 1 Dimes: 1 Nickels: 1";  //gives a constant to test against
    Assert.assertEquals(constantResult, Money.changeDue(.40)); //runs a comparison to the constant and calls the function with its parameter to return a string
    //
    String constantResult2 = "Quarters: 2 Dimes: 1 Nickels: 1";  //gives a constant to test against
    Assert.assertEquals(constantResult2, Money.changeDue(.65)); //runs a comparison to the constant and calls the function with its parameter to return a
    String constantResult3 = "Quarters: 6 Dimes: 2 Nickels: 0";  //gives a constant to test against
    Assert.assertEquals(constantResult3, Money.changeDue(1.70)); //runs a comparison to the constant and calls the function with its parameter to return a
    String constantResult4 = "Quarters: 26 Dimes: 0 Nickels: 0";  //gives a constant to test against
    Assert.assertEquals(constantResult4, Money.changeDue(6.50)); //runs a comparison to the constant and calls the function with its parameter to return a
    String constantResult5 = "Quarters: 5 Dimes: 1 Nickels: 0";  //gives a constant to test against
    Assert.assertEquals(constantResult5, Money.changeDue(1.35)); //runs a comparison to the constant and calls the function with its parameter to return a
    String constantResult6 = "Quarters: 17 Dimes: 1 Nickels: 1";  //gives a constant to test against
    Assert.assertEquals(constantResult6, Money.changeDue(4.40)); //runs a comparison to the constant and calls the function with its parameter to return a

}



}