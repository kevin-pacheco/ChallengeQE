package seleniumgluecode;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class Background extends TestBase {
    // ------------------------
    // Background
    // ------------------------
    @Given("^the user is in the login page$")
    public void the_user_is_in_the_login_page() throws Throwable {
        Assert.assertEquals("https://demoapp.byappdirect.com/login", driver.getCurrentUrl());
    }

    @When("^the user login with email and password$")
    public void the_user_login_with_email_and_password() throws Throwable {
        loginPage.loginWithEmailandPassword("kevin.pacheco@tsoftglobal.com", "Bghp2@rH@vPd5i");
    }

    @When("^the user open the orders$")
    public void the_user_open_the_orders() throws Throwable {
        homePage.selectOperationsFromNav();
        homePage.selectOrdersFromBilling();
    }

    @Then("^the user is logged in$")
    public void theUserIsLoggedIn() {
        Assert.assertTrue(homePage.profileButtonIsDisplayed());
    }

    @Then("^the user is in the orders page$")
    public void theUserIsInTheOrdersPage() throws Throwable {
        Assert.assertTrue(ordersPage.orderTitleIsDisplayed());
    }

}