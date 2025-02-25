package controller;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class websiteController {
    WebDriver driver;

    public static WebDriverWait wait;

    @FindBy(css = "img[src='/images/Toolsqa.jpg']")
    WebElement toolsQaImage;
    @FindBy(css = "svg[viewBox='0 0 448 512']")
    WebElement elementButton;

    @FindBy(xpath = "//span[text()='Text Box']")
    WebElement textBox;

    @FindBy(css = "input[placeholder='Full Name']")
    WebElement fullNameInputBox;

    @FindBy(css = "input[placeholder='name@example.com']")
    WebElement emailBox;

    @FindBy(css = "textarea[placeholder='Current Address']")
    WebElement currentAddress;

    @FindBy(css = "textarea[id='permanentAddress']")
    WebElement permanentAddress;

    @FindBy(xpath = "//button[text()='Submit']")
    WebElement submitButton;

    @FindBy(css = "p[id='email']")
    WebElement emailVerify;

    @FindBy(css = "p[id='name']")
    WebElement nameVerify;

    @FindBy(css = "p[id='currentAddress']")
    WebElement currentAddressVerify;

    @FindBy(css = "p[id='permanentAddress']")
    WebElement permanentAddressVerify;

    public websiteController(WebDriver driver){
        driver = new ChromeDriver();
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void openWebsite() {
        driver.get("https://demoqa.com/");

    }

    public boolean verifyMainScreen(){
        boolean foundElement = false;
        wait.until(ExpectedConditions.visibilityOf(toolsQaImage));
        foundElement = toolsQaImage.isDisplayed();
        return foundElement;
    }

    public void clickElements (){
        wait.until(ExpectedConditions.visibilityOf(elementButton));
        elementButton.click();
    }

    public void clickTextBox (){
        wait.until(ExpectedConditions.visibilityOf(textBox));
        textBox.click();
    }

    public boolean textBoxDisplayed (){
        boolean foundElement = false;
        wait.until(ExpectedConditions.visibilityOf(fullNameInputBox));
        foundElement = fullNameInputBox.isDisplayed();
        return foundElement;
    }

    public void fillBoxes (String name, String email, String currentAddressPull, String permanentAddressPull) {
        wait.until(ExpectedConditions.visibilityOf(emailBox));
        wait.until(ExpectedConditions.visibilityOf(fullNameInputBox));
        wait.until(ExpectedConditions.visibilityOf(currentAddress));
        wait.until(ExpectedConditions.visibilityOf(permanentAddress));
        fullNameInputBox.sendKeys(name);
        emailBox.sendKeys(email);
        currentAddress.sendKeys(currentAddressPull);
        permanentAddress.sendKeys(permanentAddressPull);
    }

    public void clickSubmit () {
        wait.until(ExpectedConditions.visibilityOf(submitButton));
        submitButton.click();
    }

    public boolean infoRetrived (String name, String email, String currentAddressPull, String permanentAddressPull) {
        boolean foundElement = false;
        if (nameVerify.getText().contains(name) && emailVerify.getText().contains(email)
                && currentAddressVerify.getText().contains(currentAddressPull)
                && permanentAddressVerify.getText().contains(permanentAddressPull)) {
            foundElement = true;
        }
        return foundElement;
    }

    public void closeWebsite(){
        driver.close();
        driver.quit();
    }
}
