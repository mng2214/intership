@smoke @regression
Feature: Codefish search by category functionality

  Scenario: Testing filter by category functionality
    When User logins with positive correct credentials
    Then User switch search by category and validates items belongs to current category
