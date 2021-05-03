package com.tcgplayer.pages;

import com.tcgplayer.utilities.Driver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class BasePage {

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);

    public BasePage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }
}
