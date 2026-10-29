
Feature: Create New Group

  Scenario Outline: Successfully create a new group
    Given The user is on the login page
    And the user clicks burger menu
    And the user click login button
    And the user enters valid username <username>
    And the user enters valid password <password>
    When the user clicks the submit button
    Then the welcome message should be displayed
    And the user clicks burger menu on the dashboard
    And the user clicks Groups
    And the user clicks Create New Group
    And the user enters the group name "QA Test Group"
    And the user enters the group description "Group created through automated testing"
    And the user enters the group year "2027"
    And the user enters the maximum group capacity "25"
    And the user selects the group start date
    And the user selects the group end date
    When the user clicks Create Group

    Examples:
      | username          | password      |
      | admin@gmail.com | @12345678 |
