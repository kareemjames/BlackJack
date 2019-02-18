public class Card {

    private int rank, suit;

    private String[] suits = {"hearts", "spades", "diamonds", "clubs"};
    private String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

    public Card(int suit, int rank) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return ranks[rank] + " of " + suits[suit];
    }

    public int getRank() {
        return rank;
    }

    public int getSuit() {
        return suit;
    }
}
