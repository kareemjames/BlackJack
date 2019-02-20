import java.util.ArrayList;

public class Dealer {

    private Deck deck;

    public Dealer(Deck deck) {

        this.deck = deck;
    }

    public Deck getDeck() {

        return deck;
    }

    public void checkForEndOfDeck() {
        if (deck.getCards().size() < 5) {
            System.out.println("Reshuffle deck");
        }


    }
}




