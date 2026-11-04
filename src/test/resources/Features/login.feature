Feature: Login Feature

  Scenario Outline: Successful login with valid credentials
    Given The user is on the login page
    And the user clicks burger menu
    And the user click login button
    And the user enters valid username <username>
    And the user enters valid password <password>
    When the user clicks the submit button
    Then the welcome message should be displayed
    And the user clicks burger menu on the dashboard
    And the user scrolls to admin panel
    And the user clicks admin panel
    And the user clicks logout

    And the user changes the year



    Examples:
      | username          | password  |
      | admin@gmail.com | @12345678 |
