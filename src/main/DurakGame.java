package src.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DurakGame {
    public static List<Card> createDeck() {

        String[] cards = {
            "6 Пики", "7 Пики", "8 Пики", "9 Пики", "10 Пики", "Валет Пики","Дама Пики" ,"Король Пики", "Туз Пики",
            "6 Черви", "7 Черви", "8 Черви", "9 Черви", "10 Черви", "Валет Черви","Дама Черви" ,"Король Черви", "Туз Черви",
            "6 Бубны", "7 Бубны", "8 Бубны", "9 Бубны", "10 Бубны", "Валет Бубны","Дама Бубны" ,"Король Бубны", "Туз Бубны",
            "6 Трефы", "7 Трефы", "8 Трефы", "9 Трефы", "10 Трефы", "Валет Трефы","Дама Трефы" ,"Король Трефы", "Туз Трефы",
        };

        List<String> cardsList = Arrays.asList(cards);
        Collections.shuffle(cardsList);

        List<Card> deck = new ArrayList<>();

        for (String card : cardsList) {
            String[] split = card.split(" ");
            deck.add(new Card(split[0], split[1]));
        }

        return deck;
    }
    
    public static void dealCards(List<Card> desk, List<Card> playerFirstHand, List<Card> playerSecondHand) {
        for(int i = 0; i < 6; i++) {
            playerFirstHand.add(desk.remove(desk.size() - 1));
            playerSecondHand.add(desk.remove(desk.size() - 1));
        }
    }
}
