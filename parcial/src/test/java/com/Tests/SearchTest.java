package com.Tests;

import com.Pages.RegisterPage;
import com.Pages.SearchPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class SearchTest {
    WebDriver driver;
    SearchPage searchPage;

    @BeforeEach
    public void setUp() throws InterruptedException {
        searchPage = new SearchPage(driver);
        driver = searchPage.getChromeDriverConnection();
        searchPage.goToUrl("https://opencart.abstracta.us/index.php?route=common/home");
    }
    @AfterEach
    public void tearDown(){driver.quit();}
    @Test
    public void searchAndAddToCartSuccess(){
        searchPage.searchAndAddToCart();
    }
}
