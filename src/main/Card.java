package src.main;

public class Card {
    private String rank;
    private String suit;
    
    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }
    public String toString() {
        return rank + " " + suit + "\n";
    }
}