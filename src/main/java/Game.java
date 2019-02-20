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
    int playerTotalAfterAceCheck;
    int dealerTotalAfterAceCheck;
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

                    dealerTotal = dealerHand.addValuesOfCardsInHandWithoutAceCards();
                    dealerTotalAfterAceCheck = dealerHand.checkForAceCards(dealerTotal);

                    playerTotal = playerHand.addValuesOfCardsInHandWithoutAceCards();
                    playerTotalAfterAceCheck = playerHand.checkForAceCards(playerTotal);
                    System.out.println("Your hand's total is: " + playerTotalAfterAceCheck);
                    playerResult =  playerHand.checkFor21(playerTotalAfterAceCheck);



                    switch(playerResult){
                        case  "hit":
                            System.out.println("Would you like a hit?");
                            userInput = sc.nextLine();
                            if(userInput.equalsIgnoreCase("y")){


                                drawnCard = dealer.getDeck().drawFromDeck();
                                playerHand.addCardToHand(drawnCard);

                                System.out.println("Your new hand is: " + playerHand.getCards());
                                playerTotal = playerHand.addValuesOfCardsInHandWithoutAceCards();
                                playerTotalAfterAceCheck = playerHand.checkForAceCards(playerTotal);

                                playerHand.checkFor21(playerTotalAfterAceCheck);
                                dealerHand.declareWinner(dealerTotalAfterAceCheck, playerTotalAfterAceCheck);


                        } else if(userInput.equalsIgnoreCase("n")){

                                dealerHand.getCards();
                                dealerTotal = dealerHand.addValuesOfCardsInHandWithoutAceCards();
                                dealerTotalAfterAceCheck  = dealerHand.checkForAceCards(dealerTotal);
                                System.out.println("The dealers hand's total is: " + dealerTotalAfterAceCheck);
                                int dealerSum = dealerHand.dealerCheckFor21(dealerTotalAfterAceCheck);
                                dealerHand.declareWinner(dealerSum, playerTotalAfterAceCheck);

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
