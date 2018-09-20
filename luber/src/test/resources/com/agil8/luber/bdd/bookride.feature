Feature: book a ride

  Scenario: book a ride
    Given Steve is a driver
    When John books a ride with Steve
    Then Steve receives John's booking

  Scenario Outline: book a ride
    Given <driver> is a driver
    When <client> books a ride with <driver>
    Then <driver> receives <client>'s booking

    Examples: 
      | driver | client |
      | brian  | steve  |
      | peter  | george |

  Scenario: book first available driver
    Given these drivers
      | name  | available |
      | Brian | false     |
      | Peter | true      |
    When John books first available driver
    Then Peter receives John's booking
