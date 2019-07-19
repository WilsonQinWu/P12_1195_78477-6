/**
 * SYST 17796 Project Summer 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package project;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the code 
 * should remember to add themselves as a modifier.
 * @author megha, 2019
 */
public class Card {

    public enum Suit{Hearts,Spades,Diamands,Clubs};
    public enum Value{Ace,Two,Three,Four,Five,Six,Seven,Eight,Nine,Ten,Jack,Queen,King};
    
    private final Suit suit;
    private final Value value;
    
    Card(Suit s, Value v){
    suit=s;
    value=v;
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
