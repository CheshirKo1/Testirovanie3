package src.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import src.main.Card;
import src.main.DurakGame;

public class DurakGameSteps {
     private DurakGame game = new DurakGame();
    private List<Card> deck = game.createDeck();
    private List<Card> playerFirstHand = new ArrayList<>();
    private List<Card> playerSecondHand = new ArrayList<>();
    private List<Card> table = new ArrayList<>();

    // Scenario "Creating a deck"

    @Given("the game is initialized")
    public void initializeGame() {
        this.game = new DurakGame();
    }

    @When("the deck is created")
    public void createDeck() {
        this.deck = game.createDeck();
    }

    @Then("the deck should contain {int} cards")
    public void checkDeckSize(int size) {
        assertEquals(size, this.deck.size());
    }

}
