@FilterOrders
Feature: Filter orders
  As a customer, I want to be able to filter orders

  Background: user is logged in
    Given the user is in the login page
    When the user login with email and password
    And the user open the orders
    Then the user is logged in
    And the user is in the orders page

  Scenario Outline: Filter orders by status
    When the user filter orders by status "<status>"
    Then the user should see the orders filtered by the status "<status>"

    Examples:
      | status  |
      | Active |
      | Failed  |