Feature: Login
  Scenario: User logs in with valid credentials
    Given User is at login page
    When User enters correct Username and Password
    And User clicks go button
    Then User can visit practice page practice page
    And A message is displayed
