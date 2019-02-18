public class BlackjackDemo {

    public static void main(String[] args) {

        Deck deck = new Deck();


        System.out.println(deck.getCards());

        System.out.println(deck.getTotalCards());
        System.out.println(deck.drawFromDeck());
        System.out.println(deck.getTotalCards());
        System.out.println(deck.drawFromDeck());
        System.out.println(deck.getTotalCards());


    }
}
