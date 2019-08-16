package project;


/**
 *
 * @author acer
 */
public class Card {

    private int rank;
    private int suit;
    private int value;
    private static String[] ranks = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    private static String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};

    /*
 * Created with an integer that represents a spot in the String array ranks and the String array suits. 
     */
    Card(int suit, int values) {
        this.rank = values;
        this.suit = suit;
    }

    /*
 * Returns the string version of a card.
     */
    public String toString() {
        return ranks[rank] + " of " + suits[suit];
    }

    /*
 * Returns the rank of a card.
     */
    public int getRank() {
        return rank;
    }

    /*
 * Returns the suit of a card.
     */
    public int getSuit() {
        return suit;
    }

    /*
 * Returns the value of a card. If a jack, queen, or king the value is ten. Aces are 11 for now.
     */
    public int getValue() {
        if (rank > 10) {
            value = 10;
        }  else {
            value = rank;
        }
        return value;
    }

    /*
 * Sets the value of a card.
     */
    public void setValue(int set) {
        value = set;
    }
}
