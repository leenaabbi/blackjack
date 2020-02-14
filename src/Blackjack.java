
import java.util.ArrayList;

/**
 *
 * @author Fujitsu
 */
public class Blackjack {

    ArrayList deck = new ArrayList();
    ArrayList playerCards = new ArrayList();
    ArrayList dealerCards = new ArrayList();

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

    }

    public void play() {
        createDeck();
        showDeck();

        dealToPlayer();// deal one card player
        dealToPlayer();//deal one card to player

        dealToDealer();
        dealToDealer();

        showDeck();
        showPlayerCard();
        showDealerCard();
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
        for (int i = 0; i < playerCards.size(); i++) {
            Card c = (Card) playerCards.get(i);
            System.out.println(i + ":" + c.suit + c.rank);
        }
    }
     public void showDealerCard() {
        for (int i = 0; i < dealerCards.size(); i++) {
            Card c = (Card) dealerCards.get(i);
            System.out.println(i + ":" + c.suit + c.rank);
        }
    }

