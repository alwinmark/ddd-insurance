Feature: Person Management
  Scenario: Setzen des Alters einer Person
    Given eine neue Person mit Name "Muster" und Vorname "Max"
    When das Alter auf 30 gesetzt wird
    Then sollte das Alter 30 sein