Feature: Inventory

  Background:
    Given I am in the computer database

  Scenario: Add a Computer to the inventory
    When I click Add a new computer button
    And Enter the computer name field "test"
    And Enter the computer introduced date field "2014-04-04"
    And Enter the computer discontinued date date field "2017-04-04"
    And Select the computer company manufacturer field "Nokia"
    And Click the Create this computer button
    Then A new computer is added to the inventory with a success message

  Scenario: Filter a Computer By Name in the inventory
    When I search for computer names with min two letters "ACE"
    And click Filter by name button
    Then filtered list of computer names are displayed containing the searched name

  Scenario: Edit Computer Details in the inventory
    When I select on the computer name from list "ACE"
    And updated Computer details
    Then Computer details should be updated