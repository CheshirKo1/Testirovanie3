Feature: Durak Game

  Scenario: Creating a deck
    Given the game is initialized
    When the deck is created
    Then the deck should contain 36 cards

  Scenario: Dealing cards to players
    Given the game is initialized
    When cards are dealt to players
    Then each player should have 6 cards

  Scenario: Attacking with a card
    Given the game is initialized
    And the first player has a card
    When the first player attacks with a card
    Then the card should be on the table