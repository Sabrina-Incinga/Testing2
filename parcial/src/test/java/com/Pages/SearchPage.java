package com.Pages;

import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {
    By successAlertDiv = By.cssSelector("#product-search>div.alert.alert-success.alert-dismissible");
    By searchInput = By.name("search");
    By searchButton = By.cssSelector("#search>span>button");
    By addToCartButton = By.xpath("//*[@id=\'content\']/div[3]/div/div/div[2]/div[2]/button[1]");

    public SearchPage(WebDriver driver) {
        super();
    }

    public void searchAndAddToCart(){
        write("iphone", searchInput);
        click(searchButton);
        click(addToCartButton);
        explicitWaitByLocator(5,successAlertDiv);
        compare(successAlertDiv, "Success: You have added");
    }
}
