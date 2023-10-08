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

     public static void attack(List<Card> playerFirstHand, List<Card> playerSecondHand, List<Card> table, int cardIndex) {
        

        if (cardIndex >= 1 && cardIndex < playerFirstHand.size() + 1) {
            Card card = playerFirstHand.remove(cardIndex - 1);
            System.out.println("Вы атакуете картой: " + card);
            table.add(card);
        } else {
            System.out.println("Недопустимый номер карты. Попробуйте еще раз.");
        }
    }

     public static void defend(List<Card> playerFirstHand, List<Card> playerSecondHand, List<Card> table, Card trumpCard, int cardIndex) {
        Card attackingCard = table.get(table.size() - 1);
        
        if (cardIndex >= 1 && cardIndex < playerSecondHand.size() + 1) {

            Card card = playerSecondHand.get(cardIndex - 1);
            int valueRankCard;
            int valueAttackingRankCard;

            if(card.getRank().equals("Валет"))
                valueRankCard = 11;
            else if (card.getRank().equals("Дама"))
                valueRankCard = 12;
            else if (card.getRank().equals("Король"))
                valueRankCard = 13;
            else if (card.getRank().equals("Туз"))
                valueRankCard = 14;
            else
                valueRankCard = Integer.valueOf(card.getRank());


            if(attackingCard.getRank().equals("Валет"))
                valueAttackingRankCard = 11;
            else if (attackingCard.getRank().equals("Дама"))
                valueAttackingRankCard = 12;
            else if (attackingCard.getRank().equals("Король"))
                valueAttackingRankCard = 13;
            else if (attackingCard.getRank().equals("Туз"))
                valueAttackingRankCard = 14;
            else
                valueAttackingRankCard = Integer.valueOf(attackingCard.getRank());

            if(attackingCard.getSuit().equals(trumpCard.getSuit()) && !(card.getSuit().equals(trumpCard.getSuit()))) {
                System.out.println("Второй игрок не может отбиться и берет карты со стола.");
                playerSecondHand.addAll(table);
                table.clear();
                return;
            }

             if( !(attackingCard.getSuit().equals(trumpCard.getSuit())) && card.getSuit().equals(trumpCard.getSuit())) {
                System.out.println("Второй игрок отбивается картой: " + card.toString());
                playerFirstHand.addAll(table);
                table.clear();
                return;
            }

                
            if (valueRankCard > valueAttackingRankCard) {
                System.out.println("Второй игрок отбивается картой: " + card.toString());
                
                playerFirstHand.addAll(table);
                table.clear();
                return;
            }

            System.out.println("Второй игрок не может отбиться и берет карты со стола.");
            playerSecondHand.addAll(table);
            table.clear();

        } else {
            System.out.println("Недопустимый номер карты. Попробуйте еще раз.");
        }

        
    }
}
