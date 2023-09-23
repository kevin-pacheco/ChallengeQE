package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(css = "a[data-e2e='operations-secondary-nav-link']")
    private WebElement operationsNav;

    @FindBy(css = "button[data-testid='profile-menu-button_user']")
    private WebElement profileButton;

    @FindBy(css = "a[href='/channel/marketplace#entitlements'")
    private WebElement ordersBtnBilling;
    public HomePage(WebDriver driver) { super(driver);}

    public void selectOperationsFromNav(){
        waitForElementToBeClickable(operationsNav);
        operationsNav.click();
    }

    public boolean profileButtonIsDisplayed(){
        waitForElementToBeClickable(profileButton);
        return profileButton.isDisplayed();
    }

    public void selectOrdersFromBilling() {
        waitForElementToBeClickable(ordersBtnBilling);
        ordersBtnBilling.click();
    }
}
