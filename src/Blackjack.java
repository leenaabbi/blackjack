
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Fujitsu
 */
public class Blackjack {

    Scanner scanner = new Scanner(System.in);
    ArrayList deck = new ArrayList();
    ArrayList playerCards = new ArrayList();
    ArrayList dealerCards = new ArrayList();
    public void play() {
        createDeck();
        showDeck();

        dealToPlayer();// deal one card
        dealToDealer();
        dealToPlayer();
        dealToDealer();

        showPlayerCard();
        showDealerCard();

        while (true) {
            System.out.println("Hit or Stay");
            String choice = scanner.nextLine();
            if (choice.toUpperCase().equals("S")) {
                break;
            }
            dealToPlayer();
            if (calcPlayerSum() > 21) {
                System.out.println("Sorry you Busted Game Over");
                System.exit(0);
            }
        }

    }


    public void createDeck() {

        String[] suits = new String[]{"H", "D", "C", "S"};
        for (int j = 0; j < 4; j++) {
            for (int i = 1; i <= 13; i++) {
                Card card = new Card();
                card.suit = suits[j];
                card.rank = i;
                deck.add(card);
            }
        }
//Collections.shuffle.(deck);
    }

    
    public void showDeck() {
        for (int i = 0; i < deck.size(); i++) {
            Card c = (Card) deck.get(i);
            System.out.println(i + ":" + c.suit + c.rank);
        }
    }
    //deal two cards to player

    public void dealToPlayer() {
        Card c = (Card) deck.remove(0);
        playerCards.add(c);

    }

    //deal two cards to dealer
    public void dealToDealer() {
        Card c = (Card) deck.remove(0);
        dealerCards.add(c);

    }

    public void showPlayerCard() {
        System.out.println("Player cards:");
        for (int i = 0; i < playerCards.size(); i++) {
            Card c = (Card) playerCards.get(i);
            System.out.println(c.rank + " of " + c.suit);
        }
    }

    public void showDealerCard() {
        for (int i = 0; i < dealerCards.size(); i++) {
            Card c = (Card) dealerCards.get(i);
            System.out.println(c.rank + " of " + c.suit);
        }
    }
    int sum = 0;

    public int calcPlayerSum() {
        for (int i = 0; i < playerCards.size(); i++) {
            Card c = (Card) playerCards.get(i);
            if (c.rank > 10) {
                sum = sum + 10;
            } else {
                sum = sum + c.rank;
            }

        }
        return sum;
    }

//         while (dealer_sum < 16){
//       
//       deal a card to dealer()
//       eit game if busted
//       }
//
//if you reach this point it means no one has busted we need to compare the sums and announce the winner
}
