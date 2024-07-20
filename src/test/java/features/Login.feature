Feature: verify login function

  @tag
  Scenario: verify user able to login successfully with valid credentials
    Given user launch the application
    When user enter the login details
    And click on logout
    And close the browser

