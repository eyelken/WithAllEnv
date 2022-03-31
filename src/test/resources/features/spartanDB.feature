Feature: Connecting and getting info from Spartan DB
  @db
  Scenario: Getting info of a specific spartan with ID number
    When User gets info of a certain spartan with ID 8
    Then Spartan name should be "Rodolfo"
