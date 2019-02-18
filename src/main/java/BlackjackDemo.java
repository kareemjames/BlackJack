public class BlackjackDemo {

    public static void main(String[] args) {

        Deck deck = new Deck();
        Hand dealerHand = new Hand();
        Hand playerHand = new Hand();
        Card drawnCard;
;
        Dealer dealer = new Dealer(deck);

        //System.out.println(dealer.getDeck().drawFromDeck());
        drawnCard = dealer.getDeck().drawFromDeck();
        System.out.println(drawnCard);
        dealerHand.addCardToHand(drawnCard);
        System.out.println(dealerHand.getCards());
        drawnCard = dealer.getDeck().drawFromDeck();
        dealerHand.addCardToHand(drawnCard);
        System.out.println(dealerHand.getCards());
       // System.out.println(dealerHand.getTotalCards());
        System.out.println(dealer.getDeck().getTotalCards());
        dealerHand.addValuesOfCardsInHand();

    }
}
