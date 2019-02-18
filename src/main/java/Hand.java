import java.util.ArrayList;

public class Hand extends Deck {

    private ArrayList<Card> handToPlay;

    Hand(){
        super();
        handToPlay = new ArrayList<>();
    }

    public void addCardToHand(Card card) {
        handToPlay.add(card);
    }

    @Override
    public int getTotalCards() {
        return handToPlay.size();
    }


    @Override
    public ArrayList<Card> getCards() {
        return handToPlay;
    }

}


