import java.util.Scanner;

public class Game {

    Deck deck = new Deck();
    Hand dealerHand = new Hand();
    Hand playerHand = new Hand();
    Card drawnCard;
    Dealer dealer = new Dealer(deck);
    boolean isHitting = true;
    boolean isPlaying = true;
    Scanner sc = new Scanner(System.in);
    int userInputInt;
    String userInput;
    int dealerTotal;
    int playerTotal;
    int playerTotalAfterAceCheck;
    int dealerTotalAfterAceCheck;
    String playerResult;
    String dealerResult;
    int dealerSum;



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


                    switch(playerResult) {
                        case "hit":
                            do {
                                System.out.println("Would you like to hit[y] or stand[n]?");
                                userInput = sc.nextLine();
                                if (userInput.equalsIgnoreCase("y")) {

                                    drawnCard = dealer.getDeck().drawFromDeck();
                                    playerHand.addCardToHand(drawnCard);

                                    System.out.println("Your new hand is: " + playerHand.getCards());
                                    playerTotal = playerHand.addValuesOfCardsInHandWithoutAceCards();
                                    playerTotalAfterAceCheck = playerHand.checkForAceCards(playerTotal);
                                    playerResult = playerHand.checkFor21(playerTotalAfterAceCheck);
                                    System.out.println("Your hand's total is: " + playerTotalAfterAceCheck);
                                } else if(userInput.equalsIgnoreCase("n")){
                                    isHitting = false;
                                }

                                if (playerTotalAfterAceCheck > 21) {
                                    isHitting = false;
                                } else if(playerTotalAfterAceCheck == 21){
                                    isHitting = false;
                                }


                            } while (isHitting);


                            if (playerTotalAfterAceCheck <= 21) {
                                dealerHand.getCards();
                                dealerTotal = dealerHand.addValuesOfCardsInHandWithoutAceCards();
                                dealerTotalAfterAceCheck = dealerHand.checkForAceCards(dealerTotal);
                                System.out.println("The dealers hand's total is: " + dealerTotalAfterAceCheck);

                                dealerSum = dealerHand.dealerCheckFor21(dealerTotalAfterAceCheck);
                                dealerHand.declareWinner(dealerSum, playerTotalAfterAceCheck);

                            }
                            playerHand.clearHand();
                            dealerHand.clearHand();
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
