import java.util.Collections;
import java.util.ArrayList;


public class Deck {

    private ArrayList<Card> cards;

    Deck() {
        cards = new ArrayList<Card>();
        for (int a = 0; a <= 3; a++) {
            for (int b = 0; b <= 12; b++) {
                cards.add(new Card(a, b));
            }
        }
        Collections.shuffle(cards);
    }


    public Card drawFromDeck() {
        return cards.remove(0);
    }



    public int getTotalCards() {
        return cards.size();
    }



    public ArrayList<Card> getCards() {
        return cards;
    }


}
