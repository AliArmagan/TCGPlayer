package com.tcgplayer.pages;

import com.tcgplayer.utilities.Driver;
import com.tcgplayer.utilities.MobileDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class mobileBasePage {
    WebDriverWait wait = new WebDriverWait(MobileDriver.getDriverMobile(), 20);

    public  mobileBasePage(){

        PageFactory.initElements(new AppiumFieldDecorator(MobileDriver.getDriverMobile()),this);

    }
}
