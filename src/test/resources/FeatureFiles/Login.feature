@Login
Feature: To validate login functionality

  Background: 
    Given User is in facebook login page

  @sanity @regression
  Scenario: To validate login functionality with different credentials
    When User enter invalid username and password
      | username | password   |
      | greens   | greens@123 |
      | java     | java@123   |
      | python   | python@123 |
      | sql      | sql@123    |
    And User click login button
    Then User should be in invalid credentials page

  @sanity
  Scenario: To validate login functionality without entering login credentials
    When User click login button without entering any credentials
    Then User should be in invalid credentials page
