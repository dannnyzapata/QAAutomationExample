Feature: Consume End Point
  Scenario: End Point Verification
    When I GET the jsonplaceholder End Point and I recieve 200 response
    Then userId is 1, id is 1, and title is not empty