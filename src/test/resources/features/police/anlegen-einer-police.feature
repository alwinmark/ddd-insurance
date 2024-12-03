Feature: Partner Management
  Scenario: Anlage einer Police für einen Partner
    Given neue Partner mit:
      | partnerNr | vorname | name  | alter | geschlecht | strasse      | nr | plz   | ort         | land       | bezahlinformationen | korrespondenzsprache | iban           | kontoinhaber | email         | sozialversicherungsnummer |
      | P12345    | Max     | Muster| 30    | männlich   | Hauptstraße  | 12 | 12345 | Musterstadt | Deutschland| Kreditkarte        | Deutsch              | DE12345678901234 | Max Muster   | max@muster.de | 123456789                |
    And eine Police mit:
      | policeNr | versicherungsnehmer | versichertePerson | korrespondenzEmpfaenger | monatlichePraemie | produkte             |
      | POL123   | P12345              | P12345            | P12345                  | 350.50            | Grundversicherung, Zusatzversicherung |
    Then sollte die Police korrekt angelegt sein