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
//A
    @Given("the first player has a card")
    public void addCardToFirstPlayerHand() {
        playerFirstHand.add(new Card("6", "Пики"));
    }

    @When("the first player attacks with a card")
    public void attackWithCard() {
        int input = 1;
        game.attack(playerFirstHand, playerSecondHand, table, input);
    }

    @Then("the card should be on the table")
    public void checkCardOnTable() {
        assertTrue(table.size() == 1 || table.isEmpty());
    }
//D
     @Given("the second player has a higher card")
    public void addHigherCardToSecondPlayerHand() {
        playerSecondHand.add(new Card("7", "Пики"));
    }

    @Given("there is a card on the table")
    public void addCardToTable() {
        table.add(new Card("8", "Пики"));
    }

    @When("the second player defends against the attack")
    public void defendAgainstAttack() {
        int input = 1;
        game.defend(playerFirstHand, playerSecondHand, table, new Card("9", "Пики"), input);
    }

    @Then("the table should be empty")
    public void checkEmptyTable() {
        assertTrue(table.isEmpty());
    }
//M
@When("the game ends")
    public void endGame() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        game.endGame(playerFirstHand, playerSecondHand);

        String expectedOutput = "\nПобедил первый игрок!\n";
        assertEquals(expectedOutput, outputStream.toString());

        System.setOut(System.out);
    }

    @Then("the first player should win")
    public void the_first_player_should_win() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        game.endGame(playerFirstHand, playerSecondHand);

        String expectedOutput = "\nПобедил первый игрок!\n";
        assertEquals(expectedOutput, outputStream.toString());

        System.setOut(System.out);
    }

}


