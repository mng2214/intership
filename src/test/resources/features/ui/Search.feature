@smoke @regression
Feature: Codefish search functionality


  Scenario Outline: Testing positive search functionality
    When User provides  correct credentials and login
    Then User search for item by '<Item Name>' from catalog and validates it
    Examples:
      | Item Name |
      | Pfizer    |
      | Sputnik   |
      | NIKON     |
