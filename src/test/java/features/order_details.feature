@OrderDetails
Feature: Order details
  As a customer, I want to be able to view my Order Details

  Background: user is logged in
    Given the user is in the login page
    When the user login with email and password
    And the user open the orders
    Then the user is logged in
    And the user is in the orders page

  Scenario: Show order details
    When the user selects one of the orders available
    And the user opens the details of the order
    Then the user should see the details of the order selected
