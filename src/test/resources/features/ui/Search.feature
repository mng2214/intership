@smoke @regression
Feature: Codefish search functionality


  Scenario Outline: Testing positive search functionality
    When User login on the website
    Then User search for item by '<Item Name>' from catalog and validates it
    Examples:
      | Item Name |
      | Pfizer    |
      | Sputnik   |
      | NIKON     |
