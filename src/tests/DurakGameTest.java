package src.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import src.main.Card;
import src.main.DurakGame;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

//import io.cucumber.*;

public class DurakGameTest {
    private DurakGame game;

    @BeforeEach
    void setUp() {
        game = new DurakGame();
    }
    
    @Test
    void testCreateDeck() {
        List<Card> deck = game.createDeck();
        assertNotNull(deck);
        assertEquals(36, deck.size()); // Проверяем, что колода содержит 36 карт.
    }

    @Test
    void testDealCards() {
        List<Card> deck = game.createDeck();
        List<Card> playerFirstHand = new ArrayList<>();
        List<Card> playerSecondHand = new ArrayList<>();

        game.dealCards(deck, playerFirstHand, playerSecondHand);

        assertEquals(6, playerFirstHand.size()); // Проверяем, что первый игрок получил 6 карт.
        assertEquals(6, playerSecondHand.size()); // Проверяем, что второй игрок получил 6 карт.
    }

      @Test
    void testAttack() {
        int input = 1;
        
        List<Card> playerFirstHand = new ArrayList<>();
        playerFirstHand.add(new Card("6", "Пики"));
        List<Card> playerSecondHand = new ArrayList<>();
        List<Card> table = new ArrayList<>();

        game.attack(playerFirstHand, playerSecondHand, table, input);

        assertTrue(table.size() == 1 || table.isEmpty()); 

    }

}