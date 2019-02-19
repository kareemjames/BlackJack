import java.util.Scanner;

public class Game {

    Deck deck = new Deck();
    Hand dealerHand = new Hand();
    Hand playerHand = new Hand();
    Card drawnCard;
    Dealer dealer = new Dealer(deck);
    boolean isPlaying = false;
    Scanner sc = new Scanner(System.in);
    int userInputInt;
    String userInput;
    int dealerTotal;
    int playerTotal;
    String playerResult;
    String dealerResult;


    public void startGame(){

        do{
            System.out.println("Welcome to the Black Jack Table. What would you like to do?\n" +
                    "1. Play Black Jack\n" +
                    "2. Quit game");
            userInput = sc.nextLine();

            switch (userInput){
                case "1":
                    System.out.println("Welcome to the table!");

                    drawnCard =  dealer.getDeck().drawFromDeck();
                    dealerHand.addCardToHand(drawnCard);

                    drawnCard = dealer.getDeck().drawFromDeck();
                    playerHand.addCardToHand(drawnCard);

                    drawnCard = dealer.getDeck().drawFromDeck();
                    dealerHand.addCardToHand(drawnCard);

                    drawnCard = dealer.getDeck().drawFromDeck();
                    playerHand.addCardToHand(drawnCard);

                    dealerHand.showDealerTopCard();

                    System.out.println("Your current hand is: " + playerHand.getCards());

                    dealerTotal = dealerHand.addValuesOfCardsInHand();

                    playerTotal = playerHand.addValuesOfCardsInHand();
                    System.out.println("Your hand's total is: " + playerTotal);
                    playerResult =  playerHand.checkFor21(playerTotal);


                    switch(playerResult){
                        case  "Would you like to hit?\n" +
                                "Y\n" +
                                "N":
                            userInput = sc.nextLine();
                            if(userInput.equalsIgnoreCase("y")){


                            drawnCard = dealer.getDeck().drawFromDeck();
                            playerHand.addCardToHand(drawnCard);

                                System.out.println("Your new hand is: " + playerHand.getCards());
                                playerTotal = playerHand.addValuesOfCardsInHand();
                                playerHand.checkFor21(playerTotal);


                        } else if(userInput.equalsIgnoreCase("n")){

                                dealerHand.getCards();
                                dealerTotal = dealerHand.addValuesOfCardsInHand();
                                System.out.println("The dealers hand's total is: " + dealerTotal);
                                dealerHand.dealerCheckFor21(dealerTotal);

                            }
                    }





                    break;
                case"2":
                    System.exit(0);
                    break;
                default:
                    break;
            }








        } while(isPlaying);

    }
}
