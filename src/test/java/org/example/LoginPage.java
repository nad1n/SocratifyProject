package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "email")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwdField;

    @FindBy(css = ".btn-success")
    private WebElement loginBtn;

    public void login(String login, String passwd){
        loginField.click();
        loginField.sendKeys(login);
        passwdField.click();
        passwdField.sendKeys(passwd);
        loginBtn.click();
    }
}
