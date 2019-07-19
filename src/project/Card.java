/**
 * SYST 17796 Project Summer 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package project;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the
 * code should remember to add themselves as a modifier.
 *
 * @author megha, 2019
 */
public class Card {

    public enum Suit {
        Hearts, Spades, Diamands, Clubs
    };

    public enum Value {
        Ace(1), Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8), Nine(9), Ten(10), Jack(11), Queen(12), King(13);
        private int value;

        public int getValue() {
            return value;
        }

        private Value(int value) {
            this.value = value;
        }
    }

    private final Suit suit;
    private final Value value;

    Card(Suit s, Value v) {
        suit = s;
        value = v;
    }

    /**
     * @return the suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * @return the value
     */
    public Value getValue() {
        return value;
    }
}
