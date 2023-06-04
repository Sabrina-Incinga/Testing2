package com.Tests;

import com.Pages.RegisterPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.fail;

class RegisterTest {
	WebDriver driver;
	RegisterPage registerPage;

	@BeforeEach
	public void setUp() throws InterruptedException {
		registerPage = new RegisterPage(driver);
		driver = registerPage.getChromeDriverConnection();
		registerPage.goToUrl("https://opencart.abstracta.us/index.php?route=common/home");
	}
	@AfterEach
	public void tearDown(){driver.quit();}
	@Test
	public void registerSuccessTest(){ registerPage.register(); }

}
