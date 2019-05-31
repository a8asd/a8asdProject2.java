Feature: Amend Driver Details
  I want to use this template for my feature file

  Scenario: Ayrton updates email address
    Given ayrton@test.com is a driver
    When ayrton@test.com changes his email address to ayrton@hotmail.com
    Then ayrton sees these drivers available
      | email              |
      | ayrton@hotmail.com |
