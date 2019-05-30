Feature: Customer can add own phone number
  So that customers can be contacted by phone
  As Tony
  I want to be able to add a phone number to a custer record.
  
  Tony: doesn't often use a taxi and is able-bodied

  Scenario: customer adds phone number
    Given  tony@test.com is a phonelessCustomer
    When tony@test.com adds phonenumber 016359998844
    Then tony@test.com record is
      | email         | phone        |
      | tony@test.com | 016359998844 |    	
