Feature: book a ride

  Scenario: book a ride
    Given david is a customer
    When david request a ride
    Then these drivers are available:
      | driver |
      | fred   |
      | pete   |
