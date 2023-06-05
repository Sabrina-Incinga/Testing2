package com.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasePage {
    protected static WebDriver driver;
    protected WebDriverWait wait;
    public WebDriver getChromeDriverConnection(){
        System.setProperty("webdriver.crome.driver", ".\\src\\test\\resources\\chromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(options);
        return driver;
    }
    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }
    public void write(String inputText, By locator){
        findElement(locator).clear();
        findElement(locator).sendKeys(inputText);
    }
    public void click(By locator){
        findElement(locator).click();
    }
    public void goToUrl(String url){
        driver.get(url);
    }
    public void key(By locator, String key){
        findElement(locator).sendKeys(Keys.valueOf(key));
    }
    public String getText(By locator){
        String res = findElement(locator).getText();
        return res;
    }
    public void compare(By locator, String text){
        String res = getText(locator);
        assertTrue(res.contains(text));
    }
    public void explicitWaitByText(int time, By locator, String text){
        new WebDriverWait(driver,Duration.ofSeconds(time)).
                until(ExpectedConditions.textToBePresentInElementLocated(locator,text));
    }
    public void explicitWaitByLocator(int time, By locator){
        new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
