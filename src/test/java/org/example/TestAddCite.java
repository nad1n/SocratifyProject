package org.example;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestAddCite {

    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static AddCitePage addCitePage;
    public static CitesPage citesPage;
    public static MainMenu mainMenu;
    public static MyCitePage myCitePage;

    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        mainMenu = new MainMenu(driver);
        addCitePage = new AddCitePage(driver);
        myCitePage = new MyCitePage(driver);
        driver.manage().window().setSize(new Dimension(1248, 883));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginPage"));
    }

    @Test
    public void loginTest(){
        loginPage.login(ConfProperties.getProperty("email"), ConfProperties.getProperty("password"));

        //Check login
        mainMenu.moveToProfilePage();
        Assert.assertEquals(ConfProperties.getProperty("login"), profilePage.getUserName());
    }

    @Test
    public void createCiteTest() {
        profilePage.moveToMyCite();
        //Assert.assertTrue(myCitePage.getHeadPage() == "Добавленные цитаты");
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertFalse("Text found!", bodyText.contains(ConfProperties.getProperty("author1")));

        mainMenu.moveToCites();
        //Check page
        //Assert.assertTrue(citesPage.getTitlePageName() == "Цитаты и пословицы ▷ Socratify.Net");

        //Create new cite
        citesPage.addCite();
        driver.get("https://socratify.net/quotes/create");
        addCitePage.createCite(ConfProperties.getProperty("cite1"), ConfProperties.getProperty("author1"), ConfProperties.getProperty("category1"));

        //Check added cite
        mainMenu.moveToProfilePage();
        profilePage.moveToMyCite();
        Assert.assertEquals(ConfProperties.getProperty("author1"), myCitePage.getTextCite());
    }

    @Test
    public void likeCite(){

        //Check before
        mainMenu.moveToProfilePage();
        profilePage.moveToLikedCite();
        //Assert

        mainMenu.moveToCites();
        citesPage.addLike();

        //Check added like
        mainMenu.moveToProfilePage();
        profilePage.moveToLikedCite();
        //Assert

    }


    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
