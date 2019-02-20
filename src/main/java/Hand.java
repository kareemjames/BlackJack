import java.util.ArrayList;
import java.util.Scanner;

public class Hand extends Deck {

    private ArrayList<Card> handToPlay;
    private int valueReturnedFromDealerCheckFor21;
    private Scanner scan = new Scanner(System.in);
    private String userInput;


    Hand() {
        super();
        handToPlay = new ArrayList<>();
    }

    public int addValuesOfCardsInHandWithoutAceCards() {
        int sum = 0;
        for (int i = 0; i < handToPlay.size(); i++) {
            if (handToPlay.get(i).getRank() >= 1 && handToPlay.get(i).getRank() < 9) {
                sum += handToPlay.get(i).getRank() + 1;
                // System.out.println(sum);
            } else if (handToPlay.get(i).getRank() >= 9 && handToPlay.get(i).getRank() <= 12) {
                sum += 10;
                //  System.out.println(sum);
            }
        }
        return sum;


    }

    public int checkForAceCards(int sumBeforeAceCheck) {
        int sum = sumBeforeAceCheck;
        for (int i = 0; i < handToPlay.size(); i++) {
            if (handToPlay.get(i).getRank() == 0 && sum < 11) {
                sum += 11;
            }
                if(handToPlay.get(i).getRank() == 0 && sum > 11){
                sum += 1;
            }
        }
        return sum;
    }

    public String checkFor21(int total) {
        String result = "";
        if (total < 21) {
            result = "hit";
        } else if (total > 21) {
            result = "bust";
            System.out.println("You've busted.");
        } else if (total == 21) {
            result = "win";
            System.out.println("You've won!");
        }
        return result;
    }

    public int dealerCheckFor21(int total) {
        int sum = total;
        System.out.println(sum);

        while(sum < 17){
            System.out.println(handToPlay);
            handToPlay.add(drawFromDeck());
            System.out.println(handToPlay);
            sum = addValuesOfCardsInHandWithoutAceCards();
            System.out.println(sum);
        }

        if (sum >= 17 && sum <= 20) {
            System.out.println(handToPlay);
            System.out.println("Dealer stays.");
        }

        if (sum == 21) {
            System.out.println(handToPlay);
            System.out.println("Dealer has 21.");
        }

        if (sum > 21) {
            System.out.println(handToPlay);
            System.out.println("Dealer busts.");
        }

        return sum;
    }

    public void showDealerTopCard() {
        System.out.println("The dealer is showing: " + handToPlay.get(1));
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

    public void declareWinner(int dealerTotal, int playerTotal) {
        if(dealerTotal > playerTotal && dealerTotal <= 21 || playerTotal > 21){
            System.out.println("The dealer wins!");
        } else if (dealerTotal < playerTotal && playerTotal <= 21 || dealerTotal > 21){
            System.out.println("The player wins!");
        } else {
            System.out.println("It's a draw.");
        }
    }
}


