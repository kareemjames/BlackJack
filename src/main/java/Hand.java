import java.util.ArrayList;

public class Hand extends Deck {

    private ArrayList<Card> handToPlay;


    Hand(){
        super();
        handToPlay = new ArrayList<>();
    }

    public void checkFor21() {
        int sum = 0;
        for (int i = 0; i < handToPlay.size(); i++) {
           if (handToPlay.get(i).getRank() >= 1 && handToPlay.get(i).getRank() < 9) {
               sum += handToPlay.get(i).getRank() + 1;
               System.out.println(sum);
           } else if(handToPlay.get(i).getRank() >= 9 && handToPlay.get(i).getRank() <= 12){
               sum += 10;
               System.out.println(sum);
           } else if(handToPlay.get(i).getRank() == 0){
               if(sum <= 11){
                   sum += 11;
               }else {
                   sum += 1;
               }
           }
        }
        System.out.println(sum);
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


