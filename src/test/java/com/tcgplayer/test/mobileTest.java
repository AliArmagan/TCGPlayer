package com.tcgplayer.test;

import com.tcgplayer.pages.mobileFirstPage;
import com.tcgplayer.utilities.BrowserUtils;
import com.tcgplayer.utilities.Driver;
import com.tcgplayer.utilities.MobileDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class mobileTest{
    mobileFirstPage mobile = new mobileFirstPage();
    @BeforeTest
    public void setup() {
        System.out.println("::: Starting Automation:::");

     MobileDriver.getDriverMobile().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @AfterTest
    public void tearDown() {
        MobileDriver.closeDriver();
        System.out.println(":::(^_^) End of test execution (*_*):::");
    }
    @Test(priority = 1)
    public void search(){
        mobile.getUrlMobile();
        mobile.Search("Silver");
        BrowserUtils.wait(1);

        mobile.getResultCount("488 results for: “Silver” in All Products");
    }

    @Test(priority = 2)
    public void filtered(){
        mobile.filter();
        BrowserUtils.wait(1);

    }

    @Test(priority = 3)
    public void verifyPrice(){
        mobile.price("$0.99");
    }

    @Test(priority = 4)
    public void verifyItemsInCart(){
        mobile.NumberOfItemInCart("1");
    }

}
