package seleniumgluecode;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class OrdersPageSteps extends TestBase{
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


    // ------------------------
    // Orders Details Feature
    // ------------------------
    @When("^the user selects one of the orders available$")
    public void the_user_selects_one_of_the_orders_available() throws Throwable {
        ordersPage.selectOrderByIndex(1);
    }

    @When("^the user opens the details of the order$")
    public void the_user_opens_the_details_of_the_order() throws Throwable {
        ordersPage.openOrderDetails();
    }

    @Then("^the user should see the details of the order selected$")
    public void the_user_should_see_the_details_of_the_order_selected() throws Throwable {
        Assert.assertTrue(ordersPage.itemsTableIsDisplayed());
    }



}
