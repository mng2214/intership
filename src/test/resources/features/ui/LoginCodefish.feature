@smoke @regression
Feature: Codefish login functionality

  Scenario: Positive login functionality
    When User provides 'username' and 'passowrd'
    Then User validates title 'title'


  Scenario Outline: Negative login functionality
    When User provides '<username>' and '<password>'
    Then User validates message '<message>'
    Examples:
      | username | password | message               |
      |          |          | Authentication failed |
      | admin    | wrong    | Authentication failed |
      | wrong    | adming   | Authentication failed |
      | admin    |          | Authentication failed |
      |          | wromg    | Authentication failed |

