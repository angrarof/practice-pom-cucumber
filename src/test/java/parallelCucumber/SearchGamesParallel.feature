Feature: Search different games

  @smoke
  Scenario: validate Suggested Games
    Given I load home page
    When I write slug game for search
    Then I validate system displays more than 10 games
    And I validate each result contains the word slug

  Scenario: validate Suggested Games repeated
    Given I load home page
    When I write slug game for search
    Then I validate system displays more than 10 games
    And I validate each result contains the word slug