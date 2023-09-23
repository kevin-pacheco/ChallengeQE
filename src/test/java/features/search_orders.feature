@OpenOrders
Feature: Open orders
  As a customer, I want to be able to see my orders

  Background: user is logged in
    Given the user is in the login page
    When the user login with email and password
    And the user open the orders
    Then the user is logged in
    And the user is in the orders page

  Scenario: Searching an order by a string
    When the user searches for "AppDirect"
    Then the user should see the orders that contains "AppDirect"

  Scenario: Clearing the search
    Given the user searches for "AppDirect"
    When the user clears the search
    Then the search field should be empty
    And the user should see the list of all orders


