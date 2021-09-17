package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCitePage {
    public WebDriver driver;
    public AddCitePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//*[@id=\"text\"]")
    private WebElement textCiteField;

    @FindBy(xpath = "//*[@id=\"category_name\"]")
    private WebElement textCategoryField;

    @FindBy(xpath = "//*[@id=\"category_section\"]")
    private WebElement selectCategory;

    @FindBy(css=".btn-success")
    private WebElement saveBtn;

    public void createCite(String citeText, String author, String category){
        textCiteField.click();
        textCiteField.sendKeys(ConfProperties.getProperty(citeText));
        textCategoryField.click();
        textCategoryField.sendKeys(ConfProperties.getProperty(author));
        Select drpCategory = new Select(selectCategory);
        drpCategory.selectByVisibleText(category);
        saveBtn.click();
    }

}
