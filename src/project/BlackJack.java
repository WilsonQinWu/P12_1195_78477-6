package project;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author acer
 */
public class BlackJack {

    private static int AceCounter;//how many aces are in the user's hand
    private static ArrayList<Card> hand;//represents the user's hand
    private static int handvalue;//the value of the user's hand
    private static String name;//name of the user

    public static void main(String[] args) {
        System.out.println("Hi! What is your name?");
        Scanner scan = new Scanner(System.in);
        name = scan.nextLine();
        System.out.println("Hello, " + name + ", lets play some BlackJack!");
        while (name != null) {
            Deck deck = new Deck();//initialize deck, dealer, hands, and set the bet.
            deck.shuffle();
            AceCounter = 0;
            Dealer dealer = new Dealer(deck);
            List<Card> hand = new ArrayList<>();
            hand.add(deck.drawCard());
            hand.add(deck.drawCard());
            System.out.println("Here is your hand: ");
            System.out.println(hand);
            int handvalue = calcHandValue(hand);
            System.out.println("The dealer is showing: ");
            dealer.showFirstCard();

            System.out.println("Would you like to hit or stand?");//ask if the user will hit or stand
            Scanner hitorstand = new Scanner(System.in);
            String hitter = hitorstand.nextLine();
            while (!isHitorStand(hitter)) {
                System.out.println("Please enter 'hit' or 'stand'.");
                hitter = hitorstand.nextLine();
            }
            while (hitter.equals("hit"))//hits the user as many times as he or she pleases.
            {
                Hit(deck, hand);
                System.out.println("Your hand is now:");
                System.out.println(hand);
                handvalue = calcHandValue(hand);
                if (checkBust(handvalue))//checks if the user busted
                {
                    Lose();
                    break;
                }
                System.out.println("Would you like to hit or stand?");
                hitter = hitorstand.nextLine();
            }
            if (hitter.equals("stand"))//lets the user stand.
            {
                int dealerhand = dealer.takeTurn(deck);//takes the turn for the dealer.
                System.out.println("");
                System.out.println("Here is the dealer's hand:");
                dealer.showHand();
                if (dealerhand > 21)//if the dealer busted, user wins.
                {
                    System.out.println("Your Score is " + handvalue + ", Dealer Score is " + dealerhand);
                    Win();
                } else {
                    System.out.println("Your Score is " + handvalue + ", Dealer Score is " + dealerhand);
                    int you = 21 - handvalue;//check who is closer to 21 and determine winner
                    int deal = 21 - dealerhand;
                    if (you == deal) {
                        System.out.println("Your Score is " + handvalue + ", Dealer Score is " + dealerhand);
                        System.out.println("It is a tie!");
                    }
                    if (you < deal) {
                        System.out.println("Your Score is " + handvalue + ", Dealer Score is " + dealerhand);
                        Win();
                    }
                    if (deal < you) {
                        System.out.println("Your Score is " + handvalue + ", Dealer Score is " + dealerhand);
                        Lose();
                    }
                }
            }

            System.out.println("Would you like to play again?");//ask if the user wants to keep going
            Scanner yesorno = new Scanner(System.in);
            String answer = yesorno.nextLine();
            while (!isyesorno(answer)) {
                System.out.println("Please answer yes or no.");
                answer = yesorno.nextLine();
            }
            if (answer.equals("no")) {
                break;
            }
        }
    }
    /*
 * Calculates the value of a player's hand.
     */
    public static int calcHandValue(List<Card> hand) {
        Card[] aHand = new Card[]{};
        aHand = hand.toArray(aHand);
        int handvalue = 0;
        for (int i = 0; i < aHand.length; i++) {
            handvalue += aHand[i].getValue();
            if (aHand[i].getValue() == 11) {
                AceCounter++;
            }
            while (AceCounter > 0 && handvalue > 21) {
                handvalue -= 10;
                AceCounter--;
            }
        }
        return handvalue;
    }

    /*
 * Called if the user wins.
     */
    public static void Win() {
        System.out.println("Congratulations, you win!");
    }

    /*
 * Called if the user loses.
     */
    public static void Lose() {
        System.out.println("Sorry, you lose!");
    }

    /*
 * Adds a card to user's hand and calculates the value of that hand. Aces are taken into account.
     */
    public static void Hit(Deck deck, List<Card> hand) {
        hand.add(deck.drawCard());
        Card[] aHand = new Card[]{};
        aHand = hand.toArray(aHand);
        handvalue = 0;
        for (int i = 0; i < aHand.length; i++) {
            handvalue += aHand[i].getValue();
            if (aHand[i].getValue() == 11) {
                AceCounter++;
            }
            while (AceCounter > 0 && handvalue > 21) {
                handvalue -= 10;
                AceCounter--;
            }
        }
    }

    /*
 * Determines if a user has input hit or stand.
     */
    public static boolean isHitorStand(String hitter) {
        if (hitter.equals("hit") || hitter.equals("stand")) {
            return true;
        }
        return false;
    }

    /*
 * Determines if a user has busted.
     */
    public static boolean checkBust(int handvalue) {
        if (handvalue > 21) {
            System.out.println("You have busted!");
            return true;
        }
        return false;
    }

    /*
 * Determines if a user has input yes or no.
     */
    public static boolean isyesorno(String answer) {
        if (answer.equals("yes") || answer.equals("no")) {
            return true;
        }
        return false;
    }
}
