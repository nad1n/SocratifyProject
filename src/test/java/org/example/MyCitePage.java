package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyCitePage {
    public WebDriver driver;

    public MyCitePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/a")
    private WebElement textLastCite;

    public String getTextCite(){
        String textCite = textLastCite.getText();
        return textCite;
    }

    @FindBy(xpath = "/html/body/div[2]/div[3]/h1")
    private WebElement headPage;

    public String getHeadPage(){
        String textHeadPage = headPage.getText();
        return textHeadPage;
    }
}
