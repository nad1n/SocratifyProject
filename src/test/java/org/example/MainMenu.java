package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainMenu {
    public WebDriver driver;

    public MainMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "dropdownMenuPrimaryAuth")
    private WebElement profileMenu;

    @FindBy(css = ".dropdown-menu-right")
    private WebElement dropProfileMenu;

    @FindBy(xpath = "/html/body/div[1]/div/table/tbody/tr/td[3]/div/ul/li[1]/a")
    private WebElement profileLink;

    public void moveToProfilePage(){
        Actions actions = new Actions(driver);
        profileMenu.click();
        actions.moveToElement(dropProfileMenu).perform();
        profileLink.click();
    }

    @FindBy(xpath = "/html/body/div[1]/div/table/tbody/tr/td[1]/a")
    private WebElement menuCites;

    public void moveToCites (){
        menuCites.click();
    }

    @FindBy(xpath = "//*[@id=\"js-id-menu-primary\"]/a[1]")
    private WebElement menuArticles;

    public void moveToArticles (){
        menuArticles.click();
    }

    @FindBy(xpath = "//*[@id=\"js-id-menu-primary\"]/a[2]")
    private WebElement menuFacts;

    public void moveToFacts (){
        menuFacts.click();
    }

    @FindBy(xpath = "//*[@id=\"js-id-menu-primary\"]/a[2]")
    private WebElement menuTests;

    public void moveToTests (){
        menuTests.click();
    }

}
