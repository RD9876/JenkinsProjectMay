@forgotpassword
Feature: To validate forgot password feature

#@Login is a feature file level tag,so that tag is applicable for all scenarios in that
#feature file.

  Background: 
    Given User is in facebook login page

  @smoke
  Scenario Outline: To  validate searching the account using mobile number when user forgets password
    When User click forgot password link
    And User searches the account using invalid mobilenumber "<mobilenumber>"
    Then User is displayed with error message

    Examples: 
      | mobilenumber |
      |         9876 |
