Feature: Request a ride
  So that I can get to distant places without driving
  As Tony
  I want to be able to request a taxi
  
  Tony: doesn't often use a taxi and is able-bodied

  Scenario: Tony books a ride
    Given ayrton@test.com is a driver at 3, 3
    Given david@test.com is an unavailable driver at 50, 50
    Given bob@test.com is a driver at 20, 50
    And tony@test.com is a customer at 0, 0
    When Tony requests a taxi
    Then Tony sees these drivers available
      | email           | availible |
      | ayrton@test.com | true      |    	