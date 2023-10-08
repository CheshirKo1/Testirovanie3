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

  Scenario: Defending against an attack
    Given the game is initialized
    And the first player has a card
    And the second player has a higher card
    And there is a card on the table
    When the second player defends against the attack
    Then the table should be empty