
Feature: CreditCalculation
    Scenario: CreditCalculationUninsuredTerm
    Given : HomePage will be opened
    When : Credit Information part will be entered "50000","UnInsurance","20"
    And : Payment Plan will be opened
    Then : Page will be scrolled down until 20th is seen
