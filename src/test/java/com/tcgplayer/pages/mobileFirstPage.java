package com.tcgplayer.pages;

import com.tcgplayer.utilities.ConfigurationReader;
import com.tcgplayer.utilities.MobileDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class mobileFirstPage extends mobileBasePage {

    @FindBy(xpath = "//h1[@class='search-result-count']")
    private WebElement resultCount;

    @FindBy (xpath = "//input[@id='autocomplete-input']")
    private WebElement search;

    @FindBy(xpath = "(//span[@class='checkmark'])[10]")
    private WebElement WoW;

    @FindBy(xpath = "(//div[@class='search-result'])[1]")
    private WebElement firstSearchResult;

    @FindBy(xpath = "//span[@id='lowestPriceValue2']")
    private WebElement price;

    @FindBy(xpath = "//button[@id='btnAddToCart_FeaturedSeller']")
    private WebElement addCartBtn;

    @FindBy(xpath = "//div[@class='col-6 text-right']")
    private WebElement numberOfItem;

    @FindBy(xpath = "(//div//button)[7]")
    private WebElement filter;

    @FindBy(xpath = "(//button[@class='button is-normal'])[3]")
    private WebElement doneBtn;


    public void getUrlMobile(){
        MobileDriver.getDriverMobile().get(ConfigurationReader.getProperty("URL"));
    }
    public void Search(String word){
        wait.until(ExpectedConditions.visibilityOf(search));
        search.sendKeys(word + Keys.ENTER);

    }

    public void getResultCount(String result){
        wait.until(ExpectedConditions.visibilityOf(resultCount));
        Assert.assertEquals(resultCount.getText(),result);
        System.out.println(resultCount.getText());

    }

    public void filter(){
        filter.click();
        WoW.click();
        doneBtn.click();
    }
    public void price(String Price){
        firstSearchResult.click();
        wait.until(ExpectedConditions.visibilityOf(price));
        Assert.assertEquals(price.getText(), Price);
        System.out.println(price.getText() + " first item's price from search.");

    }
    public void NumberOfItemInCart(String number){
        addCartBtn.click();
        wait.until(ExpectedConditions.visibilityOf(numberOfItem));
        Assert.assertEquals(numberOfItem.getText(), number);
        System.out.println(numberOfItem.getText() + " item in the cart.");
    }


}
