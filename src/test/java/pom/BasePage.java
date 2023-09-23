package pom;

import com.sun.javafx.runtime.async.BackgroundExecutor;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    /*
     *  --- ACTIONS ---
     */
    public static void actionSendKeys(WebElement element, String nombreElemento, String value) {
        try {
            element.sendKeys(value);
        } catch (Exception e) {
            Assert.fail();
        }
    }

    public static void actionClick(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            Assert.fail();
        }
    }

    /*
     *  --- ELEMENT CONDITION ---
     */
    public boolean isDisplayed(WebElement element) throws Exception{
        try {
            return element.isDisplayed();
        }catch (Exception e){
            throw new Exception("The element " + element + "is not visible in the DOM");
        }
    }

    protected void waitForElementToAppear(WebElement element) {
        wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementToBeClickable(WebElement element){
        wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForElementToBeSelected(WebElement element){
        wait = new WebDriverWait(driver,45);
        wait.until(ExpectedConditions.elementToBeSelected(element));
    }

    protected void waitForVisibilityOfAllElements(List<WebElement> elements){
        wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
    public static void waitFor(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    /*
     *  --- ELEMENT ATTRIBUTE ---
     */
    public String getText(WebElement element) throws Exception{
        try {
            return element.getText();
        }catch (Exception e){
            throw new Exception("Text from " + element + "not available");
        }
    }

}
