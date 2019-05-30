Feature: Request a ride
  So that I can get to distant places without driving
  As Tony
  I want to be able to request a taxi
  
  Tony: doesn't often use a taxi and is able-bodied

  Scenario: Tony books a ride
  Given ayrton@test.com is a driver at 0,5
  And dave@test.com is an unavailable driver at 0,10
  And tony@test.com is a customer
  
  
	When Tony requests a taxi
    Then Tony sees these drivers available
      | email   			  | available	| xPosition | yPosition |
      | ayrton@test.com | true			|	0					|	5				|
      
     
