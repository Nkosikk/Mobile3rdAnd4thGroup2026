Feature: Login Feature

  Scenario Outline: Successful login with valid credentials
    Given the user is on the login page
    And the clicks burger menu
    And the user click login button
    And the user enters valid username <username>
    And the user enters valid password <password>
    When the user clicks the submit button
    Then the welcome message should be displayed
#    And the user click on the Admin Dashboard Burger Menu
#    And the user scroll down

    Examples:
      | username          | password  |
      | njceles@gmail.com | @12345678 |

#  Scenario : Group name successfully created
#    Given the user click on the admin Panel
#    And the user click on the second burger menu on the admin dashboard
#    And the user click on groups
#    And the user click on create new group
#    And the user enters the group name
#    And the user enters the description
#    And the user updates the year to 2027
#    And the user dismisses the keyboard
#    When the user clicks on create group
#    Then the group name should be successfully created



