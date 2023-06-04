package com.Pages;

import com.Base.BasePage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {
    By myAccountButton = By.xpath("//*[@id=\'top-links\']/ul/li[2]");
    By registerButton = By.cssSelector("#top-links>ul>li.dropdown>ul>li:nth-child(1)>a");
    By nameInput = By.name("firstname");
    By lastNameInput = By.name("lastname");
    By emailInput = By.name("email");
    By telephoneInput = By.name("telephone");
    By passwordInput = By.name("password");
    By passwordConfirmInput = By.name("confirm");
    By agreeCheckBox = By.name("agree");
    By continueButton = By.xpath("//*[@id=\'content\']/form/div/div/input[2]");
    By result = By.xpath("//*[@id=\'content\']/p[1]");

    Faker faker = new Faker();
    // Generate random email
    String email = faker.internet().emailAddress();
    public RegisterPage(WebDriver driver){
        super();
    }

    public void register(){
        String successMessage = "Congratulations! Your new account has been successfully created!";
        click(myAccountButton);
        click(registerButton);
        write("Nash", nameInput);
        write("Evans", lastNameInput);
        write(email, emailInput);
        write("(733) 434-8642", telephoneInput);
        write("IOB24BQP7OV", passwordInput);
        write("IOB24BQP7OV", passwordConfirmInput);
        click(agreeCheckBox);
        click(continueButton);
        explicitWaitByText(5, result, successMessage);
        compare(result, successMessage);
    }

}
