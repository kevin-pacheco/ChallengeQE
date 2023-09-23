package seleniumgluecode;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class Test extends TestBase{
    // ------------------------
    // Background
    // ------------------------
    @Given("^the user is in the login page$")
    public void the_user_is_in_the_login_page() throws Throwable {
        Assert.assertEquals("https://demoapp.byappdirect.com/login", driver.getCurrentUrl());
    }

    @When("^the user login with email and password$")
    public void the_user_login_with_email_and_password() throws Throwable {
        loginPage.loginWithEmailandPassword("kevin.pacheco@tsoftglobal.com","Bghp2@rH@vPd5i");
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

    // ------------------------
    // Search Orders Feature
    // ------------------------

    @When("^the user searches for \"([^\"]*)\"$")
    public void theUserSearchesFor(String arg1) throws Throwable {
        ordersPage.searchOrdersThatContains(arg1);
    }

    @Then("^the user should see the orders that contains \"([^\"]*)\"$")
    public void theUserShouldSeeTheOrdersThatContains(String arg1) throws Throwable {
        Assert.assertTrue(ordersPage.listOfProductsShownContains(arg1));
    }

    @When("^the user clears the search$")
    public void theUserClearsTheSearch() throws Throwable {
        ordersPage.clearSearch();
    }

    @Then("^the search field should be empty$")
    public void theSearchFieldShouldBeEmpty() throws Throwable {
        Assert.assertTrue(ordersPage.searchFieldIsEmpty());
    }

    @Then("^the user should see the list of all orders$")
    public void theUserShouldSeeTheListOfAllOrders() throws Throwable {
        ordersPage.ordersListHasMoreThanOrEqualTo(5);
    }

    // ------------------------
    // Filter Orders Feature
    // ------------------------
    @When("^the user filter orders by status \"([^\"]*)\"$")
    public void the_user_filter_orders_by_status(String arg1) throws Throwable {
        ordersPage.filterOrdersWithStatus(arg1);
    }

    @Then("^the user should see the orders filtered by the status \"([^\"]*)\"$")
    public void theUserShouldSeeTheOrdersFilteredByTheStatus(String status) throws Throwable {
        ordersPage.listOfStatusShownContains(status);
    }


}
