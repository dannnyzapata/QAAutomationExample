Feature: Send and verify data
  Scenario: Send email and data
    Given I open demoqa website
    Then I Verify I'm in the Mainscreen
    When I Click Elements
    When I Click Text Box
    Then I Verify I'm in the Text Box Screen
    When I fill information: "Daniel Zapata", "123@email.com", "123 Main St" and "135 Main St"
    When I Click Submit
    Then The "Daniel Zapata", "123@email.com", "123 Main St" and "135 Main St" are correct
    And I Close demoqa website