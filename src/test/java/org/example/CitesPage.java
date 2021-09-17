package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitesPage {
    public WebDriver driver;
    public CitesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//*[@class=\"b-menu-secondary\"]/a[1]")
    private WebElement addCiteBtn;

    public void addCite(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"b-menu-secondary\"]/a[1]")));
        addCiteBtn.click();
    }

    @FindBy(xpath = "/html/head/title")
    private WebElement titlePage;

    public String getTitlePageName(){
        String pageName = titlePage.getText();
        return pageName;
    }

    @FindBy(xpath = "/html/body/div[2]/div[4]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div/span")
    private WebElement likeBtn;

    public void addLike(){
        likeBtn.click();
    }

}
