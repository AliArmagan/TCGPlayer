package com.tcgplayer.test;

import com.tcgplayer.pages.FirstPage;
import com.tcgplayer.utilities.BrowserUtils;
import com.tcgplayer.utilities.Driver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstPageTest {
    FirstPage firstPage = new FirstPage();

    @BeforeTest
    public void setup() {
        System.out.println("::: Starting Automation:::");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @AfterTest
    public void tearDown() {
        Driver.closeDriver();
        System.out.println(":::(^_^) End of test execution (*_*):::");
    }

    @Test(priority = 1)
    public void search(){
        firstPage.getUrl();
        firstPage.Search("Silver");
        BrowserUtils.wait(1);

        firstPage.getResultCount("488 results for: “Silver” in All Products");
    }

    @Test(priority = 2)
    public void filtered(){
        firstPage.filter();
        BrowserUtils.wait(1);

    }

    @Test(priority = 3)
    public void verifyPrice(){
        firstPage.price("$0.99");
    }

    @Test(priority = 4)
    public void verifyItemsInCart(){
        firstPage.NumberOfItemInCart("1");
    }


}
