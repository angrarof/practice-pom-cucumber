Feature: Search different games

  @smoke
  Scenario: Validate Suggested Games
    Given I load home page
    When I write slug game for search
    Then I validate system displays more than 4 games
    And I validate each result contains the word slug