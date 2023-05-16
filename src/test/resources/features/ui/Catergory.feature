@smoke @regression
Feature: Codefish search by category functionality

  Scenario: Testing filter by category functionality
    When User provides  correct credentials and login
    Then User switch search by category and validates items belongs to current category
