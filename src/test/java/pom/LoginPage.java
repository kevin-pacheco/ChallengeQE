package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailInput;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[contains(text(),'Next')]")
    private WebElement btnNext;
    @FindBy(xpath = "//button[contains(text(),'Log In')]")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver) {super(driver);}

    public void loginWithEmailandPassword(String email, String password){
        waitForElementToBeClickable(emailInput);
        emailInput.sendKeys(email);
        btnNext.click();
        waitForElementToBeClickable(passwordInput);
        passwordInput.sendKeys(password);
        waitForElementToBeClickable(loginBtn);
        loginBtn.click();
    }

}
