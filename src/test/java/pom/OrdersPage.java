package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class OrdersPage extends BasePage{

    @FindBy(css = "h1.adb-header--item")
    private WebElement headerTitle;

    @FindBys(@FindBy (css = "tr.handle-key"))
    private List<WebElement> ordersList;

    @FindBy(xpath = "//input[@data-auto='search_input']")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@data-auto='search_icon']")
    private WebElement searchButton;

    @FindBys(@FindBy(css = "tr.handle-key td.product"))
    private List<WebElement> productsNameList;

    @FindBys(@FindBy(css = "tr.handle-key td.status-text-container"))
    private List<WebElement> statusNameList;

    @FindBy(css = "button[data-auto='showFilters']")
    private WebElement showFiltersBtn;

    @FindBy(css = "button[data-auto=''hideFilters]")
    private WebElement hideFiltersBtn;

    @FindBy(xpath = "//div[label[contains(text(),'Status')]]//select[@aria-label='select']")
    private WebElement selectStatus;

    @FindBys(@FindBy(xpath = "//div[label[contains(text(),'Status')]]//select[@aria-label='select']//option"))
    private List<WebElement> optionsFromSelect;

    public OrdersPage(WebDriver driver) { super(driver);}

    public boolean orderTitleIsDisplayed(){
        waitFor(5);
        return headerTitle.isDisplayed();
    }

    public boolean ordersListHasMoreThanOrEqualTo(int numberOfElements){
        waitFor(3);
        return ordersList.size()>=numberOfElements;
    }

    public void searchOrdersThatContains(String text){
        waitForElementToBeClickable(searchInput);
        searchInput.sendKeys(text);
        waitForElementToBeClickable(searchButton);
        searchButton.click();
    }

    public boolean listOfProductsShownContains(String text){
        waitFor(4);
        return productsNameList.stream().filter(element -> element.getText().contains(text)).count()>0;
    }

    public void clearSearch(){
        waitForElementToBeClickable(searchInput);
        searchInput.clear();
        searchButton.click();
    }

    public boolean searchFieldIsEmpty(){
        waitForElementToBeClickable(searchInput);
        return searchInput.getText().equals("");
    }

    public void filterOrdersWithStatus(String status){
        waitForElementToBeClickable(showFiltersBtn);
        showFiltersBtn.click();
        waitFor(2);
        selectStatus.click();
        waitFor(3);
        for (WebElement option : optionsFromSelect) {
            if(option.getText().equalsIgnoreCase(status)){
                option.click();
                break;
            }
        }
    }


    public boolean listOfStatusShownContains(String text) {
        waitFor(4);
        return statusNameList.stream().filter(element -> element.getText().contains(text)).count()>0;
    }
}
