Feature: Login Feature

  Scenario Outline: Successful login with valid credentials
    Given the user is on the login page
    When the user enters valid username <username>
    And the user enters valid password <password>
    And the user clicks the login button
    Then the user should be logged in successfully
    And a welcome message should be displayed

    Examples:
      | username | password |
      | user1    | pass1    |
      | user2    | pass2    |
