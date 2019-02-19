import java.util.ArrayList;

public class Hand extends Deck {

    private ArrayList<Card> handToPlay;
    private int valueReturnedFromDealerCheckFor21;


    Hand() {
        super();
        handToPlay = new ArrayList<>();
    }

    public int addValuesOfCardsInHand() {
        int sum = 0;
        for (int i = 0; i < handToPlay.size(); i++) {
            if (handToPlay.get(i).getRank() >= 1 && handToPlay.get(i).getRank() < 9) {
                sum += handToPlay.get(i).getRank() + 1;
                // System.out.println(sum);
            } else if (handToPlay.get(i).getRank() >= 9 && handToPlay.get(i).getRank() <= 12) {
                sum += 10;
                //  System.out.println(sum);
            } else if (handToPlay.get(i).getRank() == 0) {
                if (sum < 11) {
                    sum += 11;
                } else {
                    sum += 1;
                }
            }
        }
        return sum;


    }



    public String checkFor21(int total) {
        String result = "";
        if (total < 21) {
            result = "Would you like to hit?";
        } else if (total > 21) {
            result = "You busted.";
        } else if (total == 21) {
            result = "You win.";
        }
        return result;
    }

    public void dealerCheckFor21(int total) {
        int sum = total;

        for (int i = 0; i < handToPlay.size(); i++) {
            if (sum < 17) {
                handToPlay.add(drawFromDeck());
                System.out.println(handToPlay);
                sum += addValuesOfCardsInHand();
            } else if (total >= 17 && total <= 20) {
                System.out.println("Dealer stays.");
            } else {
                System.out.println("Dealer busts.");
            }
        }
    }

    public void showDealerTopCard(){
        System.out.println("The dealer is showing: " + handToPlay.get(1));
    }

    public void addCardToHand(Card card){
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


