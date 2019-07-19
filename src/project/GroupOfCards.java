/**
 * SYST 17796 Project Summer 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game.
 * HINT, you might want to subclass this more than once.
 * The group of cards has a maximum size attribute which is flexible for reuse.
 * @author megha,2019
 */
public class GroupOfCards 
{
   private int handSize = 52;
    public Card[] cards = new Card[handSize];

    //generate hand of 52 cards
    public void generateHand() {

        int countCards = 0;
        for (Card.Suit s : Card.Suit.values()) {
            for (Card.Value v : Card.Value.values()) {
                cards[countCards] = (new Card(s, v));
                countCards++;
            }
        }
    }
}

