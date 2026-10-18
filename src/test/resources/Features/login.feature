Feature: Login Feature

  Scenario Outline: Successful login with valid credentials
    Given the user is on the login page
    And the user click login button
    And the user enters valid username <username>
    And the user enters valid password <password>
    When the user clicks the submit button
    Then the welcome message should be displayed

    Examples:
      | username          | password  |
      | njceles@gmail.com | @12345678 |
