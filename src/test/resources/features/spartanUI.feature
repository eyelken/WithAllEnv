Feature: Managing my Spartans Army
  Agile Story: As the Commander of Spartans army,
  I should be able to manage my army so that I can win the wars
  @spartans
  Scenario: Viewing selected Spartans info
    Given Commander is at the main page
    When Commander clicks on view button of the spartan with the ID number 3
    Then Verifies the name of the spartan is "Fidole"
