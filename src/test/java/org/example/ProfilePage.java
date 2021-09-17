package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

    public WebDriver driver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//*[@id=\"js-id-menu-secondary\"]/a[1]")
    private WebElement infoProfile;

    public void moveToInfoProfile (){
        infoProfile.click();
    }

    @FindBy(xpath = "//*[@id=\"js-id-menu-secondary\"]/a[2]")
    private WebElement myCite;

    public void moveToMyCite(){
        myCite.click();
    }

    @FindBy(xpath = "//*[@id=\"js-id-menu-secondary\"]/a[3]")
    private WebElement favoriteCite;

    public void moveToFavCite(){
        favoriteCite.click();
    }

    @FindBy(xpath = "//*[@id=\"js-id-menu-secondary\"]/a[4]")
    private WebElement likedCite;

    public void moveToLikedCite(){
        likedCite.click();
    }

    @FindBy(xpath = "//*[@id=\"js-id-menu-secondary\"]/a[4]")
    private WebElement myComments;

    public void moveToMyComments(){
        myComments.click();
    }


    @FindBy(xpath = "//*[@id=\"user-settings\"]/ul/li[1]/a/b")
    private WebElement userLogin;

    public String getUserName() {
        String userName = userLogin.getText();
        return userName;
    }


}
