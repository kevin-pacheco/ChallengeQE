package seleniumgluecode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pom.HomePage;
import pom.LoginPage;
import pom.OrdersPage;

public class TestBase {
    protected WebDriver driver = Hooks.getDriver();
    protected LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
    protected HomePage homePage = PageFactory.initElements(driver,HomePage.class);
    protected OrdersPage ordersPage = PageFactory.initElements(driver,OrdersPage.class);

}
