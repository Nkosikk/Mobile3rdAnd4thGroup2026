Feature: Login Feature

  Scenario Outline: Successful login with valid credentials
    Given the user is on the login page
    And the user clicks burger menu
    And the user click login button
    And the user enters valid username <username>
    And the user enters valid password <password>
    When the user clicks the submit button
    Then the welcome message should be displayed

    Examples:
      | username          | password  |
      | titi@gmail.com | tlou@97LT |
